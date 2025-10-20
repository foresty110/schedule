package schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

/* UpdateScheduleResponse
 * ---------------------------
 *  일정 수정(Update) 요청 이후, 수정된 정보를 클라이언트에 반환하기 위한 응답 DTO입니다. */
@Getter
public class UpdateScheduleResponse {

    private final Long id; //아이디
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
