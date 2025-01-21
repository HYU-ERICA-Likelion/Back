package lion.homepage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@AllArgsConstructor
public class MemberInterviewRequestDto {

    private String name;
    private Integer generation;
}
