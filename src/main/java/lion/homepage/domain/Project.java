package lion.homepage.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    private String name;

    private String description;

    private String type; // 타입 필드는 무슨 목적일까요?

    private Integer generation;

    private LocalDateTime createdAt;

    private String deploymentUrl;

    private String thumbnailUrl;

    @OneToMany(mappedBy = "photo", cascade = CascadeType.REMOVE)
    private List<Photo> photos;

    @OneToMany(mappedBy = "project_member")
    private List<ProjectMember> projectMember;
}
