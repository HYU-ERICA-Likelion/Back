package lion.homepage.repository;

import lion.homepage.domain.Member;
import lion.homepage.service.MemberService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberCustomRepository {

    @Query("SELECT DISTINCT m, r.role FROM Member m JOIN m.generationRoles r ORDER BY r.role, m.id ASC")
    List<Member> findLeaderMembersOrderedByRole();
}
