package lion.homepage.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String photoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    //추후 이미지 저장 방식에 따라 필드 추가할 수 있음
}
