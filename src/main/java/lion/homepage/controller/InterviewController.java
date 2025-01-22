package lion.homepage.controller;

import lion.homepage.domain.Interview;
import lion.homepage.domain.Member;
import lion.homepage.dto.InterviewDto;
import lion.homepage.dto.MemberDescriptionDto;
import lion.homepage.dto.MemberInterviewRequestDto;
import lion.homepage.dto.MemberInterviewResponseDto;
import lion.homepage.enums.Role;
import lion.homepage.repository.InterviewRepository;
import lion.homepage.repository.MemberRepository;
import lion.homepage.service.InterviewService;
import lion.homepage.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequiredArgsConstructor
public class InterviewController {

    private final MemberService memberService;

    @GetMapping("/interview")
    @ResponseBody
    public MemberInterviewResponseDto getPersonalInterviews(MemberInterviewRequestDto memberInterviewRequestDto) {
        Member member = memberService.findMemberByNameAndGeneration(memberInterviewRequestDto.getName(), memberInterviewRequestDto.getGeneration());
        List<InterviewDto> interviewDtoList = member.getInterviews().stream()
                .map(i -> new InterviewDto(i.getQuestion(), i.getAnswer())).toList();
        return new MemberInterviewResponseDto(member.getPhotoUrl(), member.getName(), member.getGeneration(), member.getRole(), interviewDtoList);
    }

    @GetMapping("generation/interview")
    @ResponseBody
    public ResponseEntity<List<MemberDescriptionDto>> getEveryMemberDescription() {
        List<Member> members = memberService.findAll();
        List<MemberDescriptionDto> memberDescriptionDtoList = members.stream()
                .map(m -> new MemberDescriptionDto(m.getName(), m.getGeneration(), m.getRole(), m.getPhotoUrl(), m.getDescription())).toList();
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(memberDescriptionDtoList);
    }
}
