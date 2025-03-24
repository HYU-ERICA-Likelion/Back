package lion.homepage.dto;

import lion.homepage.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberRoleDto {
    private String name;

    private RoleType role;
}
