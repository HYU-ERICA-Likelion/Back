package lion.homepage.repository;

import lion.homepage.domain.Interview;
import lion.homepage.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
}
