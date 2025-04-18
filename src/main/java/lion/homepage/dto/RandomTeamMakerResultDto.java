package lion.homepage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
public class RandomTeamMakerResultDto {
    List<TeamDto> teamDtoList;
}
