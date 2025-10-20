package schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

/* CreateScheduleRequest
 * ---------------------------
 * 댓글 생성 응답 DTO */
@Getter
public class CreateCommentResponse {

    private final Long id; //일정 id
    private final Long scheduleId; //일정 id
    private final String content;// 댓글 내용
    private final String author;// 작성자명
    private final LocalDateTime createdAt;// 작성일
    private final LocalDateTime modifiedAt;// 수정일

    public CreateCommentResponse(Long id, Long scheduleId, String content, String author, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.scheduleId = scheduleId;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
