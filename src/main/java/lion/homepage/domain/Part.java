package lion.homepage.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id")
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "part")
    private List<Curriculum> curriculums = new ArrayList<>();
}
