package lion.homepage.controller;

import lion.homepage.domain.Project;
import lion.homepage.dto.ProjectMemberDto;
import lion.homepage.dto.ProjectResponseDto;
import lion.homepage.dto.PhotoDto;
import lion.homepage.dto.MemberDescriptionDto;
import lion.homepage.enums.RoleType;
import lion.homepage.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    // 모든 프로젝트 반환
    @GetMapping
    public ResponseEntity<List<ProjectResponseDto>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        List<ProjectResponseDto> projectDtos = projects.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(projectDtos);
    }

    // 프로젝트 ID로 프로젝트 반환
    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> getProjectById(@PathVariable Long id) {
        Optional<Project> project = projectService.getProjectById(id);
        return project.map(p -> ResponseEntity.ok(convertToDto(p)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    // 기수로 프로젝트 반환
//    @GetMapping("/generation/{generation}")
//    public ResponseEntity<List<ProjectResponseDto>> getProjectsByGeneration(@PathVariable Integer generation) {
//        List<Project> projects = projectService.getProjectsByGeneration(generation);
//        List<ProjectResponseDto> projectDtos = projects.stream()
//                .map(this::convertToDto)
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(projectDtos);
//    }

    // 프로젝트 생성
    // TODO : 프로젝트 생성 시 photo도 함께 생성 (cloud storage에 저장)
    @PostMapping
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody Project project) {
        Project savedProject = projectService.saveProject(project);
        return ResponseEntity.status(201).body(convertToDto(savedProject));
    }

    // 프로젝트 수정
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    private ProjectResponseDto convertToDto(Project project) {
        Integer generation = project.getGeneration();

        return new ProjectResponseDto(
                project.getId(),
                project.getName(),
                project.getTeamName(),
                project.getLongDescription(),
                project.getProjectType(),
                generation,
                project.getStartDate(),
                project.getEndDate(),
                project.getDeploymentUrl(),
                project.getThumbnailUrl(),
                project.getPhotos().stream().map(photo -> new PhotoDto(photo.getId(), photo.getPhotoUrl())).collect(Collectors.toList()),
                project.getProjectMember().stream().map(pm -> new ProjectMemberDto(pm.getMember().getId(), pm.getMember().getName(), pm.getProjectRole().getKorean())).collect(Collectors.toList())
                        //map(pm -> new MemberDescriptionDto(pm.getMember().getId(), pm.getMember().getName(), pm.getMember().getGenerations().stream().map(Generation::getGeneration).collect(Collectors.toList()), List.of(pm.getProjectRole()), pm.getMember().getPhotoUrl(), pm.getMember().getDescription())).collect(Collectors.toList())
        );
    }
}