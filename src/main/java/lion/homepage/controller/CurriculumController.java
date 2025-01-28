package lion.homepage.controller;

import lion.homepage.dto.CurriculumDto;
import lion.homepage.service.CurriculumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curriculums")
@RequiredArgsConstructor
public class CurriculumController {
    private final CurriculumService curriculumService;

    @GetMapping
    public ResponseEntity<List<CurriculumDto>> getAllCurriculums() {
        return ResponseEntity.ok(curriculumService.findAllCurriculums());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurriculumDto> getCurriculum(@PathVariable Long id) {
        return ResponseEntity.ok(curriculumService.findById(id));
    }

    @GetMapping("/part/{partId}")
    public ResponseEntity<List<CurriculumDto>> getCurriculumsByPart(@PathVariable Long partId) {
        return ResponseEntity.ok(curriculumService.findByPartId(partId));
    }

    @PostMapping
    public ResponseEntity<Long> createCurriculum(@RequestBody CurriculumDto curriculumDto) {
        Long id = curriculumService.saveCurriculum(curriculumDto);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCurriculum(@PathVariable Long id,
                                               @RequestBody CurriculumDto curriculumDto) {
        curriculumService.updateCurriculum(id, curriculumDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculum(@PathVariable Long id) {
        curriculumService.deleteCurriculum(id);
        return ResponseEntity.ok().build();
    }
}