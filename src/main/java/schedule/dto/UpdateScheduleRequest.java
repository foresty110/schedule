package schedule.dto;

import lombok.Getter;

/* UpdateScheduleRequest
 * ---------------------------
 * 일정 수정 요청을 위한 데이터 전송 객체(DTO)입니다. */
@Getter
public class UpdateScheduleRequest {
    private String title; //일정 제목
    private String author; //작성자명
    private String password; // 비밀번호
}
