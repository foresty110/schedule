package schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/* Comment
 * ---------------------------
 * 댓글 정보를 표현하는 JPA 엔티티 클래스입니다. */
@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 댓글 고유ID
    private Long scheduleId; //일정 고유ID
    @Column(length = 100 , nullable = false)
    private String content; //댓글 내용
    @Column(nullable = false)
    private String author; //작성자명
    @Column(nullable = false)
    private String password; //비밀번호

    public Comment(Long scheduleId, String content, String author, String password) {
        this.scheduleId = scheduleId;
        this.content = content;
        this.author = author;
        this.password = password;
    }
}
