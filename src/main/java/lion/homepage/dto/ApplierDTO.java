package lion.homepage.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApplierDTO {
    private String nickname;
    private String part;
}
