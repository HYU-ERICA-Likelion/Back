package lion.homepage.controller;

import java.util.List;
import java.util.stream.Collectors;
import lion.homepage.domain.Applier;
import lion.homepage.domain.IdeaPost;
import lion.homepage.dto.ApplierDTO;
import lion.homepage.dto.IdeaPostDTO;
import lion.homepage.dto.OneIdeaPostDTO;
import lion.homepage.service.IdeaPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class IdeaPostController {
    private final IdeaPostService ideaPostService;

    //    IdeaPost 갖고오기
    @GetMapping("/posts")
    public ResponseEntity<List<IdeaPostDTO>> getAllIdeaPosts() {
        List<IdeaPost> ideaPosts = ideaPostService.findAll();
        System.out.println(ideaPosts);

        List<IdeaPostDTO> ideaPostDTOS = ideaPosts.stream()
                .map(post -> new IdeaPostDTO(
                        post.getId(),
                        post.getTopic(),
                        post.getDescription(),
                        post.getProjectType(),
                        post.getImageUrl()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(ideaPostDTOS);
    }

    //    IdeaPost 생성
    @PostMapping("/post")
    public ResponseEntity<IdeaPostDTO> createIdeaPost(@RequestBody IdeaPost ideaPost) {
        IdeaPost createdIdeaPost = ideaPostService.save(ideaPost);

        System.out.println("Received topic: " + ideaPost.getTopic());
        System.out.println("Received topic: " + createdIdeaPost.getTopic());
        return ResponseEntity.ok(new IdeaPostDTO(createdIdeaPost.getId(), createdIdeaPost.getTopic(),
                createdIdeaPost.getDescription(), createdIdeaPost.getProjectType(), createdIdeaPost.getImageUrl()));
    }

    //    개별 아이디로 IdeaPost 반환
    @GetMapping("/posts/{id}")
    public ResponseEntity<OneIdeaPostDTO> getIdeaPost(@PathVariable Long id) {
        IdeaPost ideaPost = ideaPostService.findById(id);
        OneIdeaPostDTO oneIdeaPostDTO = new OneIdeaPostDTO(
                ideaPost.getId(),
                ideaPost.getTopic(),
                ideaPost.getProjectType(),
                ideaPost.getDescription(),
                ideaPost.getFrontendAppNum(),
                ideaPost.getBackendAppNum(),
                ideaPost.getDesignAppNum(),
                ideaPost.getImageUrl(),
                ideaPost.getGroupChatLink()
        );
        return ResponseEntity.ok(oneIdeaPostDTO);
    }

//    지원
    @PostMapping("/posts/{id}")
    public ResponseEntity<String> applyForIdeaPost(@PathVariable Long id, @RequestBody ApplierDTO request) {
        IdeaPost ideaPost = ideaPostService.findById(id);
        if (ideaPost == null) {
            return ResponseEntity.notFound().build();
        }

        Applier applier = new Applier(request.getNickname(), request.getPart(), ideaPost);

        if ("frontend".equalsIgnoreCase(request.getPart())) {
            ideaPost.setFrontendAppNum(ideaPost.getFrontendAppNum() - 1);
        } else if ("backend".equalsIgnoreCase(request.getPart())) {
            ideaPost.setBackendAppNum(ideaPost.getBackendAppNum() - 1);
        } else if ("design".equalsIgnoreCase(request.getPart())) {
            ideaPost.setDesignAppNum(ideaPost.getDesignAppNum() - 1);
        }

        IdeaPost updatedIdeaPost = ideaPostService.save(ideaPost);

        return ResponseEntity.ok("지원 완료");
    }
}
