package lion.homepage.controller;

    import lion.homepage.domain.Member;
    import lion.homepage.dto.MemberDescriptionDto;
    import lion.homepage.service.MemberService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;
    import java.util.stream.Collectors;

    @RestController
    @RequestMapping("/members")
    @RequiredArgsConstructor
    public class MemberController {

        private final MemberService memberService;

        @GetMapping
        public ResponseEntity<List<MemberDescriptionDto>> getAllLeaders() {
            List<Member> members = memberService.findNotNormalMembers();
            List<MemberDescriptionDto> memberDtos = members.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(memberDtos);
        }

        @GetMapping("/search")
        public ResponseEntity<MemberDescriptionDto> getMemberByNameAndGeneration(@RequestParam String name, @RequestParam Integer generation) {
            Optional<Member> member = memberService.findMemberByNameAndGeneration(name, generation);
            return member.map(m -> ResponseEntity.ok(convertToDto(m)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        private MemberDescriptionDto convertToDto(Member member) {
            return new MemberDescriptionDto(
                    member.getName(),
                    member.getGeneration(),
                    member.getRole().getKorean(),
                    member.getPhotoUrl(),
                    member.getDescription()
            );
        }
    }