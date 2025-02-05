package lion.homepage.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "generation")
public class Generation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 기수 번호

    private String name;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    // 추가 필드

    // 기수에 속한 프로젝트들
    // 하나의 기수에 여러 프로젝트가 있을 수 있음 (1:N)
    @OneToMany(mappedBy = "generation")
    private List<Project> projects = new ArrayList<>();

    // 기수에 속한 멤버들
    @ManyToMany(mappedBy = "generations")
    private List<Member> members = new ArrayList<>();
}

