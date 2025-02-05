package lion.homepage.service;

import lion.homepage.domain.Interview;
import lion.homepage.domain.Member;
import lion.homepage.repository.InterviewRepository;
import lion.homepage.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class InterviewService {
    private final InterviewRepository interviewRepository;
    private final MemberRepository memberRepository;

    public List<Interview> getInterviewsByMemberId(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        return interviewRepository.findByMember(member.get());
    }


}
