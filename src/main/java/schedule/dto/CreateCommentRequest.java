package schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateCommentRequest {

    private String content;// 댓글 내용
    private String author;// 작성자명
    private String password;// 비밀번호

}
