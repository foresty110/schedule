package schedule.dto;

import lombok.Getter;

/* CreateScheduleRequest
 * ---------------------------
 * 일정 생성 요청 DTO */
@Getter
public class CreateScheduleRequest {

    private String title;// 일정 제목
    private String content;// 일정 내용
    private String author;// 작성자명
    private String password;// 비밀번호

}
