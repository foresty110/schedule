package schedule.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequest {
    private String title; //일정 제목
    private String author; //작성자명
    private String password; // 비밀번호
}
