package schedule.service;

import schedule.Repository.ScheduleRepository;
import schedule.dto.*;
import schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/* ScheduleService
 * ---------------------------
 * 일정과 관련된 비즈니스 로직을 처리하는 서비스 클래스입니다.
 * 일정 데이터의 생성, 조회, 수정, 삭제 기능을 제공합니다.
 */
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository; //일정 데이터
    private final CommentService commentService; // 일정 데이터 반환 시 해당 일정에 등록된 댓글을 함께 반환하며 이때 사용합니다.

    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest createScheduleRequest) {

        Schedule schedule = new Schedule(
                createScheduleRequest.getTitle(),
                createScheduleRequest.getContent(),
                createScheduleRequest.getAuthor(),
                createScheduleRequest.getPassword()
        );

        scheduleRepository.save(schedule);

        return new CreateScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getAuthor(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public GetOneScheduleResponse getOne(long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 id입니다.")
        );

        //일정에 등록된 댓글 찾기
        List<GetOneCommentResponse> commentResponses = commentService.getAll(schedule.getId());

        return new GetOneScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getAuthor(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt(),
                commentResponses
        );
    }

    @Transactional(readOnly = true)
    public List<GetAllScheduleResponse> getAll(String author) {

        // 작성자명으로 전체 스케쥴 조회
        List<Schedule> schedules = scheduleRepository.findAllByAuthor(author);

        List<GetAllScheduleResponse> responses = new ArrayList<>();
        for (Schedule schedule : schedules) {
            responses.add(new GetAllScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getAuthor(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            ));
        }
        responses.sort((a, b) -> b.getModifiedAt().compareTo(a.getModifiedAt()));
        return responses;
    }

    @Transactional
    public UpdateScheduleResponse update(Long id, UpdateScheduleRequest request) {

        //id 검사
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 id입니다.")
        );

        //password 검사
        if (!schedule.getPassword().equals(request.getPassword())) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }

        schedule.update(
                request.getTitle(),
                request.getAuthor()
        );

        return new UpdateScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getAuthor(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public void delete(long id, String password) {

        //id 검사
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 id입니다.")
        );

        //password 검사
        if (!schedule.getPassword().equals(password)) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }

        //일정 삭제
        scheduleRepository.deleteById(id);
    }
}