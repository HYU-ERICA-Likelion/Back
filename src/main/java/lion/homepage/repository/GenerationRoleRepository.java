package lion.homepage.repository;

import lion.homepage.domain.GenerationRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenerationRoleRepository extends JpaRepository<GenerationRole, Integer> {
}