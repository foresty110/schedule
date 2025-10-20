package schedule.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import schedule.entity.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    long countByScheduleId(Long scheduleId); // 같은 일정id를 가진 댓글 개수 조회
    List<Comment> findAllByScheduleId(long id); // 일정id를 기준으로 모든 댓글 데이터 조회
}
