package lion.homepage.domain;

import jakarta.persistence.*;
import lion.homepage.enums.ProjectType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import lombok.Setter;

@Entity
@Getter
public class IdeaPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idea_post_id")
    private Long id;

    private String topic;

    private String description;

    private String nickname;

    private String groupChatLink;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private ProjectType projectType;

    @Setter
    private Integer backendAppNum;

    @Setter
    private Integer frontendAppNum;

    @Setter
    private Integer designAppNum;

    @OneToMany(mappedBy = "ideaPost", cascade = CascadeType.REMOVE)
    private List<Applier> appliers = new ArrayList<>();
}
