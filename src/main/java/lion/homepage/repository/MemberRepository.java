package lion.homepage.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lion.homepage.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findById(long id);
}
