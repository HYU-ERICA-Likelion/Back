package lion.homepage.service;

import lion.homepage.domain.Generation;
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

    public Optional<Project> getProjectsByNameAndGeneration(String name, Integer generationId) {
        return projectRepository.findByNameAndGenerationId(name, generationId);
    }

    public List<Project> getProjectsByGeneration(Integer generationId) {
        return projectRepository.findByGenerationId(generationId);
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}