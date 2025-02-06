package lion.homepage.repository;

import lion.homepage.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByNameAndGenerationsId(String name, Integer generationId);
    List<Member> findByGenerationsId(Integer generationId);

    @Query("SELECT DISTINCT m FROM Member m JOIN m.roles r WHERE r.roleType != 8 ORDER BY r.roleType, m.id ASC")
    List<Member> findLeaderMembersOrderedByRole();
}
