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

    // 모든 커리큘럼 반환
    @GetMapping
    public ResponseEntity<List<CurriculumDto>> getAllCurriculums() {
        return ResponseEntity.ok(curriculumService.findAllCurriculums());
    }

    // 커리큘럼 ID로 커리큘럼 반환
    @GetMapping("/{id}")
    public ResponseEntity<CurriculumDto> getCurriculum(@PathVariable Long id) {
        return ResponseEntity.ok(curriculumService.findById(id));
    }

    // 파트 ID로 커리큘럼 반환
    @GetMapping("/part/{partId}")
    public ResponseEntity<List<CurriculumDto>> getCurriculumsByPart(@PathVariable Long partId) {
        return ResponseEntity.ok(curriculumService.findByPartId(partId));
    }

    // 커리큘럼 생성
    @PostMapping
    public ResponseEntity<Long> createCurriculum(@RequestBody CurriculumDto curriculumDto) {
        Long id = curriculumService.saveCurriculum(curriculumDto);
        return ResponseEntity.ok(id);
    }

    // 커리큘럼 수정
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCurriculum(@PathVariable Long id,
                                               @RequestBody CurriculumDto curriculumDto) {
        curriculumService.updateCurriculum(id, curriculumDto);
        return ResponseEntity.ok().build();
    }

    // 커리큘럼 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculum(@PathVariable Long id) {
        curriculumService.deleteCurriculum(id);
        return ResponseEntity.ok().build();
    }
}