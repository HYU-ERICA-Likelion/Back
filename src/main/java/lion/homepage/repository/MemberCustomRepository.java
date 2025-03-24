package lion.homepage.repository;

import lion.homepage.dto.MemberRoleDto;

import java.util.List;

public interface MemberCustomRepository {
    List<MemberRoleDto> findNormalMembers();
}
