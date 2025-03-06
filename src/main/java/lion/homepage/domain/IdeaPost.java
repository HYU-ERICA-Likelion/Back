package lion.homepage.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class IdeaPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idea_post_id")
    private Long id;

    private String topic;

    private String description;

    private String groupChatLink;

    private Integer backendAppNum;

    private Integer frontendAppNum;

    private Integer designAppNum;

    @OneToMany(mappedBy = "idea_post", cascade = CascadeType.REMOVE)
    private List<Applier> appliers = new ArrayList<>();
}
