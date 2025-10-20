package schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/* Schedule
 * ---------------------------
 * 일정 정보를 표현하는 JPA 엔티티 클래스입니다. */
@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //일정 고유ID
    @Column(length = 30 , nullable = false)
    private String title;//일정 제목
    @Column(length = 200 , nullable = false)
    private String content; //일정 내용
    @Column(nullable = false)
    private String author; //작성자명
    @Column(nullable = false)
    private String password; // 비밀번호

    public Schedule(String title, String content, String author, String password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }

    public void update(String title, String author) {
        this.title = title;
        this.author = author;
    }

}
