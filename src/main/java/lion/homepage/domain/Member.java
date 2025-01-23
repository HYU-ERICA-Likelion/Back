package lion.homepage.domain;

import jakarta.persistence.*;
import lion.homepage.enums.Role;
import lombok.Getter;

import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private Integer generation;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String photoUrl;

    private String description;

    @OneToMany(mappedBy = "member")
    private List<Interview> interviews = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<ProjectMember> projectMembers = new ArrayList<>();
}
