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

    // 멤버가 기수 여러개 가질 수 있음 -> 멤버와 기수로 멤버 찾기하면 여러개가 나옴 -> 삭제
//    public Optional<Member> findMemberByNameAndGeneration(String name, Integer generationId) {
//        return memberRepository.findByNameAndGenerationsId(name, generationId);
//    }
}
