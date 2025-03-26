package lion.homepage.dto;

import lion.homepage.enums.ProjectType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IdeaPostDTO {
    private Long id;
    private String title;
    private String content;
    private ProjectType projectType;
    private String imageUrl;
}
