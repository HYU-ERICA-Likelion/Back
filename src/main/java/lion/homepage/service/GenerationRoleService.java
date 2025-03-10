package lion.homepage.service;

import lion.homepage.domain.GenerationRole;
import lion.homepage.repository.GenerationRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenerationRoleService {

    private GenerationRoleRepository generationRoleRepository;

    public List<GenerationRole> findAll() {
        return generationRoleRepository.findAll();
    }

    public Optional<GenerationRole> findById(Integer id) {
        return generationRoleRepository.findById(id);
    }

    public GenerationRole save(GenerationRole generation) {
        return generationRoleRepository.save(generation);
    }

    public void deleteById(Integer id) {
        generationRoleRepository.deleteById(id);
    }
}