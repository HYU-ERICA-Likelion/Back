package lion.homepage.repository;

import lion.homepage.domain.SecurityCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecurityCodeRepository extends JpaRepository<SecurityCode, Long> {
    Optional<SecurityCode> findByCode(String code);
}
