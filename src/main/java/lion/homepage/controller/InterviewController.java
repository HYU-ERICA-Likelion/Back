package lion.homepage.controller;

import lion.homepage.domain.Interview;
import lion.homepage.domain.Member;
import lion.homepage.dto.InterviewDto;
import lion.homepage.dto.MemberInterviewRequestDto;
import lion.homepage.dto.MemberInterviewResponseDto;
import lion.homepage.enums.Role;
import lion.homepage.repository.InterviewRepository;
import lion.homepage.repository.MemberRepository;
import lion.homepage.service.InterviewService;
import lion.homepage.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class InterviewController {

    private final MemberService memberService;

    @GetMapping("/interview")
    @ResponseBody
    public MemberInterviewResponseDto interview(MemberInterviewRequestDto memberInterviewRequestDto) {
        Member member = memberService.findMemberByNameAndGeneration(memberInterviewRequestDto.getName(), memberInterviewRequestDto.getGeneration());
        List<InterviewDto> interviewDtoList = member.getInterviews().stream()
                .map(i -> new InterviewDto(i.getQuestion(), i.getAnswer())).toList();
        return new MemberInterviewResponseDto(member.getPhotoUrl(), member.getName(),
                makeGenerationAndRoleString(member.getGeneration(), member.getRole()), interviewDtoList);
    }

    private String makeGenerationAndRoleString(Integer generation, Role role) {
        return generation + " " + role;
    }
}
