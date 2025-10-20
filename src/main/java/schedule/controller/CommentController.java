package schedule.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import schedule.dto.CreateCommentRequest;
import schedule.dto.CreateCommentResponse;
import schedule.service.CommentService;

/* CommentController
 * ---------------------------
 * 댓글 관련 REST API를 처리하는 컨트롤러 클래스입니다. */
@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService; // 댓글 비즈니스 로직을 수행하는 서비스

    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CreateCommentResponse> createComment(@PathVariable Long scheduleId, @RequestBody CreateCommentRequest request) {
        CreateCommentResponse response = commentService.save(scheduleId,request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
