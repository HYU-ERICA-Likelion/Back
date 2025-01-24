package lion.homepage.service;

import lion.homepage.domain.Project;
import lion.homepage.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public Optional<Project> getProjectsByNameAndGeneration(String name, Integer generation) {
        return projectRepository.findByNameAndGeneration(name, generation);
    }

    public Optional<Project> getProjectsByGeneration(Integer generation) {
        return projectRepository.findByGeneration(generation);
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}