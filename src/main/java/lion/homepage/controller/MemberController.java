package lion.homepage.controller;

    import lion.homepage.domain.Generation;
    import lion.homepage.domain.Member;
    import lion.homepage.domain.Role;
    import lion.homepage.dto.MemberDescriptionDto;
    import lion.homepage.enums.RoleType;
    import lion.homepage.service.MemberService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.context.support.BeanDefinitionDsl;
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

        // 모든 멤버 반환
        @GetMapping
        public ResponseEntity<List<MemberDescriptionDto>> getAllMembers() {
            List<Member> members = memberService.findAll();
            List<MemberDescriptionDto> memberDtos = members.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(memberDtos);
        }


        // 멤버 ID로 멤버 반환
        @GetMapping("/search")
        public ResponseEntity<MemberDescriptionDto> getMemberById(@RequestParam Long id) {
            Optional<Member> member = memberService.findById(id);
            return member.map(m -> ResponseEntity.ok(convertToDto(m)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        // 모든 멤버 중 리더 멤버만 반환
        @GetMapping("/generation")
        public ResponseEntity<List<MemberDescriptionDto>> getMembersByGeneration() {
            List<Member> members = memberService.getLeaderMembersOrderByRole();
            List<MemberDescriptionDto> memberDtos = members.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(memberDtos);
        }

        private MemberDescriptionDto convertToDto(Member member) {
            List<String> roles = member.getRoles().stream()
                    .map(role -> role.getRoleType().getKorean()).collect(Collectors.toList());

            List<Integer> generations = member.getGenerations().stream()
                    .map(Generation::getGeneration).collect(Collectors.toList());

            return new MemberDescriptionDto(
                    member.getId(),
                    member.getName(),
                    generations,
                    roles,
                    member.getPhotoUrl(),
                    member.getDescription()
            );
        }
    }