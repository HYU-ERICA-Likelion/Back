package lion.homepage.dto;

import lion.homepage.domain.Curriculum;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CurriculumDto {
    private Long id;
    private String title;
    private String description;
    private Integer week;
    private Long partId;

    public static CurriculumDto from(Curriculum curriculum) {
        CurriculumDto dto = new CurriculumDto();
        dto.setId(curriculum.getId());
        dto.setTitle(curriculum.getTitle());
        dto.setDescription(curriculum.getDescription());
        dto.setWeek(curriculum.getWeek());
        dto.setPartId(curriculum.getPart().getId());
        return dto;
    }
}