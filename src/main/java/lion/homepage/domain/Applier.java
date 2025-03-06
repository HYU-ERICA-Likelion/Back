package lion.homepage.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Applier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String part;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idea_post_id")
    private IdeaPost ideaPost;
}
