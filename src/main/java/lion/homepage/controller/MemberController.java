package lion.homepage.controller;

    import lion.homepage.domain.Member;
    import lion.homepage.dto.MemberDescriptionDto;
    import lion.homepage.enums.RoleType;
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
        public ResponseEntity<List<MemberDescriptionDto>> getAllMembers() {
            List<Member> members = memberService.findAll();
            List<MemberDescriptionDto> memberDtos = members.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(memberDtos);
        }

        @GetMapping("/search")
        public ResponseEntity<MemberDescriptionDto> getMemberById(@RequestParam Long id) {
            Optional<Member> member = memberService.findById(id);
            return member.map(m -> ResponseEntity.ok(convertToDto(m)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        private MemberDescriptionDto convertToDto(Member member) {
            List<RoleType> roles = member.getRoles().stream()
                    .map(role -> RoleType.valueOf(role.getRoleType().name())).collect(Collectors.toList());

            return new MemberDescriptionDto(
                    member.getId(),
                    member.getName(),
                    roles,
                    member.getPhotoUrl(),
                    member.getDescription()
            );
        }
    }