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
        
        //기수별로 멤버 조회 추가해야함
        // 프론트에서 운영진 정보 다 넘겨주면 알아서 기수로 필터링해서 출력하는 방식이어서 운영진 멤버 전체 보내주면 될 것 같아요
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