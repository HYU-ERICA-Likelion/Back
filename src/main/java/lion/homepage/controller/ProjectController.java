package lion.homepage.controller;

import lion.homepage.domain.Project;
import lion.homepage.domain.Generation;
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

    @GetMapping
    public ResponseEntity<List<ProjectResponseDto>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        List<ProjectResponseDto> projectDtos = projects.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(projectDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> getProjectById(@PathVariable Long id) {
        Optional<Project> project = projectService.getProjectById(id);
        return project.map(p -> ResponseEntity.ok(convertToDto(p)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

@GetMapping("/generation/{generation}")
public ResponseEntity<List<ProjectResponseDto>> getProjectsByGeneration(@PathVariable Integer generation) {
    List<Project> projects = projectService.getProjectsByGeneration(generation);
    List<ProjectResponseDto> projectDtos = projects.stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    return ResponseEntity.ok(projectDtos);
}

    @PostMapping
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody Project project) {
        Project savedProject = projectService.saveProject(project);
        return ResponseEntity.status(201).body(convertToDto(savedProject));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    private ProjectResponseDto convertToDto(Project project) {
        Integer generation = project.getGeneration().getId();

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
                project.getProjectMember().stream().map(pm -> new MemberDescriptionDto(pm.getMember().getId(), pm.getMember().getName(), pm.getMember().getGenerations().stream().map(Generation::getGeneration).collect(Collectors.toList()), List.of(pm.getProjectRole()), pm.getMember().getPhotoUrl(), pm.getMember().getDescription())).collect(Collectors.toList())
        );
    }
}