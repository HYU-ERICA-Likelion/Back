package lion.homepage.domain;

import jakarta.persistence.*;
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

    private String photoUrl;

    private String description;

    @ManyToMany
    @JoinTable(
        name = "member_role",
        joinColumns = @JoinColumn(name = "member_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "member_generation",
        joinColumns = @JoinColumn(name = "member_id"),
        inverseJoinColumns = @JoinColumn(name = "generation_id")
    )
    private List<Generation> generations = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Interview> interviews = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<ProjectMember> projectMembers = new ArrayList<>();
}
