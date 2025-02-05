package lion.homepage.service;

import lion.homepage.domain.Generation;
import lion.homepage.repository.GenerationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenerationService {

    private GenerationRepository generationRepository;

    public List<Generation> findAll() {
        return generationRepository.findAll();
    }

    public Optional<Generation> findById(Integer id) {
        return generationRepository.findById(id);
    }

    public Generation save(Generation generation) {
        return generationRepository.save(generation);
    }

    public void deleteById(Integer id) {
        generationRepository.deleteById(id);
    }
}