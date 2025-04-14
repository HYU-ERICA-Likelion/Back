package lion.homepage.repository;

import lion.homepage.domain.Member;
import lion.homepage.dto.MemberRoleDto;

import java.util.List;

public interface MemberCustomRepository {
    List<MemberRoleDto> findNormalMembers();
    List<Member> findLeaderMembers();
}
