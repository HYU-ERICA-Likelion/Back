package lion.homepage.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curriculum_id")
    private Long id;

    private String title;

    private String description;

    private Integer week;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "part_id")
    private Part part;
}
