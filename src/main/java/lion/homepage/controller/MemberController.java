package lion.homepage.controller;

import lion.homepage.domain.Member;
import lion.homepage.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.findAll();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/search")
    public ResponseEntity<Member> getMemberByNameAndGeneration(@RequestParam String name, @RequestParam Integer generation) {
        Optional<Member> member = memberService.findMemberByNameAndGeneration(name, generation);
        return member.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}