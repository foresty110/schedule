package schedule.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {

    private Long id; //아이디
    private final String title; //일정 제목
    private final String content; //일정 내용
    private final String author; //작성자명
    private final LocalDateTime createdAt; // 작성일
    private final LocalDateTime modifiedAt; // 수정일


    public UpdateScheduleResponse(Long id, String title, String content, String author, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
