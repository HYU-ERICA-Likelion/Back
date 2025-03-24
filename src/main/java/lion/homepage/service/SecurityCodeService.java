package lion.homepage.service;
import lion.homepage.repository.SecurityCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityCodeService {

    private final SecurityCodeRepository securityCodeRepository;

    public boolean findByCode(String code) {
        return securityCodeRepository.findByCode(code).isPresent();
    }
}