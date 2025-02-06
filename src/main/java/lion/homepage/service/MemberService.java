package lion.homepage.service;

import lion.homepage.domain.Member;
import lion.homepage.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }


    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }
    public List<Member> getMembersByGeneration(Integer generation) {
        return memberRepository.findByGenerationsId(generation);
    }

    public List<Member> getLeaderMembersOrderByRole() {
        return memberRepository.findLeaderMembersOrderedByRole();
    }
}
