package lion.homepage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class RandomTeamRequestDto {
    private List<TeamInfoDto> teamList;
}
