package lion.homepage.repository;

import lion.homepage.domain.Interview;
import lion.homepage.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
    List<Interview> findByMember(Member member);
}
