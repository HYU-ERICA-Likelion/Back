package lion.homepage.dto;

import lion.homepage.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MemberDescriptionDto {
    private Long id;
    private String name;
    private List<Integer> generations;

    private List<String> roles;
    private String photoUrl;
    private String description;
}
