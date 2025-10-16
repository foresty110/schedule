package schedule.dto;

import lombok.Setter;

@Setter
public class UpdateScheduleResponse {

    private Long id; //아이디
    private final String title;//제목
    private final String content; //이름
    private final String author; //작성자명
    private final String password; // 비밀번호

    public UpdateScheduleResponse(Long id,String title, String content, String author, String password) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }
}
