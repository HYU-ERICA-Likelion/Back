package lion.homepage.service;

import java.util.List;
import lion.homepage.domain.IdeaPost;
import lion.homepage.repository.IdeaPostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class IdeaPostService {
    private final IdeaPostRepository ideaPostRepository;

    public List<IdeaPost> findAll() {
        return ideaPostRepository.findAll();
    }

    public IdeaPost findById(Long id) {
        return ideaPostRepository.findById(id).orElse(null);
    }

    public IdeaPost save(IdeaPost ideaPost) {
        return ideaPostRepository.save(ideaPost);
    }

}
