package lion.homepage.dto;

import lion.homepage.enums.ProjectType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OneIdeaPostDTO {
    private Long id;
    private String topic;
    private ProjectType projectType;
    private String description;
    private Integer front;
    private Integer back;
    private Integer design;
    private String imageUrl;
    private String chattingLink;

}
