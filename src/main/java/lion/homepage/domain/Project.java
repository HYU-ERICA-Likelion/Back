package lion.homepage.domain;

import jakarta.persistence.*;
import lion.homepage.enums.Type;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Type type;

    private Integer generation;

    private LocalDateTime createdAt;

    private String deploymentUrl;

    private String thumbnailUrl;

    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE)
    private List<Photo> photos = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<ProjectMember> projectMember = new ArrayList<>();
}
