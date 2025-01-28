package lion.homepage.service;

import lion.homepage.domain.Curriculum;
import lion.homepage.domain.Part;
import lion.homepage.dto.CurriculumDto;
import lion.homepage.repository.CurriculumRepository;
import lion.homepage.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CurriculumService {
    private final CurriculumRepository curriculumRepository;
    private final PartRepository partRepository;

    public List<CurriculumDto> findAllCurriculums() {
        return curriculumRepository.findAll().stream()
                .map(CurriculumDto::from)
                .collect(Collectors.toList());
    }

    public CurriculumDto findById(Long id) {
        Curriculum curriculum = curriculumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid curriculum Id:" + id));
        return CurriculumDto.from(curriculum);
    }

    public List<CurriculumDto> findByPartId(Long partId) {
        return curriculumRepository.findByPartId(partId).stream()
                .map(CurriculumDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long saveCurriculum(CurriculumDto curriculumDto) {
        Part part = partRepository.findById(curriculumDto.getPartId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid part Id:" + curriculumDto.getPartId()));

        Curriculum curriculum = new Curriculum();
        // Set properties using builder or setter methods
        // Note: You'll need to add appropriate setters in the Curriculum entity
        return curriculumRepository.save(curriculum).getId();
    }

    @Transactional
    public void updateCurriculum(Long id, CurriculumDto curriculumDto) {
        Curriculum curriculum = curriculumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid curriculum Id:" + id));
        // Update properties
        // Note: You'll need to add appropriate setters in the Curriculum entity
    }

    @Transactional
    public void deleteCurriculum(Long id) {
        curriculumRepository.deleteById(id);
    }
}