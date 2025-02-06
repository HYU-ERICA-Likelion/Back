package lion.homepage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProjectMemberDto {
    private Long id;
    private String name;
    private String role;
}
