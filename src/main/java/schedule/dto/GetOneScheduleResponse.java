package schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/* GetOneScheduleResponse
 * ---------------------------
 * 단일 일정 조회 응답 DTO */
@Getter
public class GetOneScheduleResponse {

    private final Long id;//일정 아이디
    private final String title;//일정 제목
    private final String content;//일정 내용
    private final String author;//작성자명
    private final LocalDateTime createdAt;//작성일
    private final LocalDateTime modifiedAt;//수정일
    private final List<GetOneCommentResponse> comments;


    public GetOneScheduleResponse(Long id, String title, String content, String author, LocalDateTime createdAt, LocalDateTime modifiedAt, List<GetOneCommentResponse> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.comments = comments;
    }
}
