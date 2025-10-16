package schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleRequest {

    private String title;// 일정 제목
    private String content;// 일정 내용
    private String author;// 작성자명
    private String password;// 비밀번호
    private LocalDateTime createdAt;// 작성일
    private LocalDateTime modifiedAt;// 수정일

}
