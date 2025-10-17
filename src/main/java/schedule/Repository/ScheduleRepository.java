package schedule.Repository;

import schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByAuthor(String author);// 작성자명을 기준으로 등록된 일정 목록을 전부 조회
}
