package lion.homepage.domain;

import jakarta.persistence.*;
import lion.homepage.enums.ProjectType;
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

    // 두 문장 정도의 프로젝트 설명 글
    private String description;

    // 한 문단의 세부 프로젝트 설명 글
    private String longDescription;

    private String teamName;

    @Enumerated(EnumType.STRING)
    private ProjectType projectType;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String deploymentUrl;

    private String thumbnailUrl;

    
    // 단일 기수 가정
    // 여러 프로젝트가 하나의 기수에 속할 수 있음 (N:1)
    @ManyToOne
    @JoinColumn(name = "generation_id")
    private Generation generation;

    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE)
    private List<Photo> photos = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<ProjectMember> projectMember = new ArrayList<>();
}
