package lion.homepage.repository;

import lion.homepage.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> findByNameAndGeneration(String name, Integer generation);
    List<Project> findByGeneration(Integer generation);


}
