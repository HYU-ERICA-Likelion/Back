package lion.homepage.dto;

import lion.homepage.domain.Interview;
import lion.homepage.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MemberInterviewResponseDto {

    private String photoUrl;
    private String name;
    private List<RoleType> roles;
    private List<InterviewDto> interviewDtoList;
}
