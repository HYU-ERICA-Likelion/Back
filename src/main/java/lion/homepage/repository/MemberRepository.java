package lion.homepage.repository;

import lion.homepage.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
//    Optional<Member> findByNameAndGenerationsId(String name, Integer generationId);
//    List<Member> findByGenerationsId(Integer generationId);

    @Query("SELECT DISTINCT m, r.role FROM Member m JOIN m.generationRoles r ORDER BY r.role, m.id ASC")
    List<Member> findLeaderMembersOrderedByRole();
}
