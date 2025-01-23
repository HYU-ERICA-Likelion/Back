package lion.homepage.service;

import lion.homepage.domain.Interview;
import lion.homepage.domain.Member;
import lion.homepage.repository.InterviewRepository;
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

}
