package lion.homepage.domain;

import jakarta.persistence.*;
import lion.homepage.enums.RoleType;
import lombok.Getter;

@Entity
@Getter
public class ProjectMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    // 멤버가 프로젝트에서 맡은 역할
    @Enumerated(EnumType.STRING)
    private RoleType projectRole;

}
