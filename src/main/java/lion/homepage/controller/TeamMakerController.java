package lion.homepage.controller;

import lion.homepage.dto.CodeRequestDto;
import lion.homepage.dto.RandomTeamMakerResultDto;
import lion.homepage.dto.RandomTeamRequestDto;
import lion.homepage.dto.RandomTeamResponseDto;
import lion.homepage.service.MemberService;
import lion.homepage.service.SecurityCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class TeamMakerController {
    private final SecurityCodeService securityCodeService;
    private final MemberService memberService;

    @GetMapping("teams/enter")
    public ResponseEntity<String> receiveCode(@RequestBody CodeRequestDto codeRequestDto) {
        if (securityCodeService.findByCode(codeRequestDto.getCode())) {
            return ResponseEntity.ok("Code is matched");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Code is wrong");
        }
    }

    @PostMapping("teams")
    public RandomTeamMakerResultDto makeRandomTeam(@RequestBody RandomTeamRequestDto randomTeamRequestDto) {
        return memberService.makeTeam(randomTeamRequestDto);
    }
}
