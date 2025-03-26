package lion.homepage.repository;

import java.util.Optional;
import lion.homepage.domain.IdeaPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaPostRepository extends JpaRepository<IdeaPost, Long> {
    Optional<IdeaPost> findById(Long id);
}
