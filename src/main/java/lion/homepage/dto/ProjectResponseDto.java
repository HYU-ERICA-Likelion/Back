package lion.homepage.dto;

import lion.homepage.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class ProjectResponseDto {

    private Long id;
    private String name;
    private String description;
    private Type type;
    private Integer generation;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String deploymentUrl;
    private String thumbnailUrl;
    private List<PhotoDto> photos;
    private List<MemberDescriptionDto> projectMembers;
}