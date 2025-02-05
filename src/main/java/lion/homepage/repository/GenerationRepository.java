package lion.homepage.repository;

import lion.homepage.domain.Generation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenerationRepository extends JpaRepository<Generation, Integer> {
}