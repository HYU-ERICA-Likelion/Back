package lion.homepage.domain;

import jakarta.persistence.*;
import lion.homepage.enums.RoleType;
import lombok.Getter;

@Entity
@Getter
public class GenerationRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer generation;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
