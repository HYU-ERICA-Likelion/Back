package lion.homepage.dto;

import lion.homepage.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberDescriptionDto {
    private String name;
    private Integer generation;
    private String role;
    private String photoUrl;
    private String description;
}
