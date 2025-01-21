package lion.homepage.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    private String question;

    private String answer;
}
