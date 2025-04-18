package lion.homepage.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import lion.homepage.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
//    Optional<Project> findByNameAndGenerationId(String name, Integer generationId);
//    List<Project> findByGenerationId(Integer generationId);


}
