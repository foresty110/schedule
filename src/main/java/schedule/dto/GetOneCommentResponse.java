package schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

/* GetOneCommentResponse
 * ---------------------------
 * 단일 댓글 조회 응답 DTO */
@Getter
public class GetOneCommentResponse {

    private final Long id;
    private final Long scheduleId;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;// 작성일
    private final LocalDateTime modifiedAt;// 수정일

    public GetOneCommentResponse(Long id, Long scheduleId, String content, String author, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.scheduleId = scheduleId;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}
