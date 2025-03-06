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

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Interview> interviews = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<ProjectMember> projectMembers = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<GenerationRole> generationRoles = new ArrayList<>();
}
