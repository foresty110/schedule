package schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {

    private final Long id;
    private final String title;// 일정 제목
    private final String content;// 일정 내용
    private final String author;// 작성자명
    private final LocalDateTime createdAt;// 작성일
    private final LocalDateTime modifiedAt;// 수정일

    public CreateScheduleResponse(Long id, String title, String content, String author, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
