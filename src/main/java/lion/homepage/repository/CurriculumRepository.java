package lion.homepage.repository;

import lion.homepage.domain.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
    List<Curriculum> findByPartId(Long partId);
    List<Curriculum> findByWeek(Integer week);
}