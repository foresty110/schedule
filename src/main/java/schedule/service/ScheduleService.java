package schedule.service;

import schedule.Repository.ScheduleRepository;
import schedule.dto.*;
import schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentService commentService;

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
    public UpdateScheduleResponse update(Long id, UpdateScheduleRequest updateScheduleRequest) {

        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 id입니다.")
        );

        schedule.update(
                updateScheduleRequest.getTitle(),
                updateScheduleRequest.getAuthor()
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
    public void delete(long id) {
        boolean exists = scheduleRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("존재하지 않는 id입니다.");
        }
        scheduleRepository.deleteById(id);
    }

}