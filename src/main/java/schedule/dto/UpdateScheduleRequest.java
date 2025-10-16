package schedule.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequest {
    private String title;//제목
    private String content; //이름
    private String author; //작성자명
    private String password; // 비밀번호
}
