package lion.homepage.controller;

import lion.homepage.domain.Interview;
import lion.homepage.domain.Member;
import lion.homepage.dto.InterviewDto;
import lion.homepage.dto.MemberDescriptionDto;
import lion.homepage.dto.MemberInterviewRequestDto;
import lion.homepage.dto.MemberInterviewResponseDto;
import lion.homepage.enums.RoleType;
import lion.homepage.repository.InterviewRepository;
import lion.homepage.repository.MemberRepository;
import lion.homepage.service.InterviewService;
import lion.homepage.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class InterviewController {

    private final MemberService memberService;


    // 멤버 ID로 인터뷰 반환
    @GetMapping("/interview")
    @ResponseBody
    public ResponseEntity<?> getPersonalInterviews(MemberInterviewRequestDto memberInterviewRequestDto) {
        Optional<Member> optionalMember = memberService.findById(memberInterviewRequestDto.getId());
        if (optionalMember.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Member Not Found"));
        }
        Member member = optionalMember.get();
        List<InterviewDto> interviewDtoList = member.getInterviews().stream()
                .map(i -> new InterviewDto(i.getQuestion(), i.getAnswer())).toList();
        List<RoleType> roles = member.getGenerationRoles().stream()
                    .map(role -> RoleType.valueOf(role.getRole().name())).collect(Collectors.toList());
        return ResponseEntity.ok(new MemberInterviewResponseDto(member.getPhotoUrl(), member.getName(), roles, interviewDtoList));
    }
}
