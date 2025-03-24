package lion.homepage.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Applier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String part;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idea_post_id")
    private IdeaPost ideaPost;

    public Applier(String nickname, String part, IdeaPost ideaPost) {
        this.nickname = nickname;
        this.part = part;
        this.ideaPost = ideaPost;
    }
}
