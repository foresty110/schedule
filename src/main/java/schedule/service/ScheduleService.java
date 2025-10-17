package schedule.service;

import org.springframework.web.bind.annotation.RequestBody;
import schedule.Repository.ScheduleRepository;
import schedule.dto.*;
import schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

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

        return new GetOneScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getAuthor(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<GetOneScheduleResponse> getAll(String author) {
        List<Schedule> schedules = scheduleRepository.findAllByAuthor(author);

        List<GetOneScheduleResponse> responses = new ArrayList<>();
        for (Schedule schedule : schedules) {
            System.out.println(schedule.getTitle());
            responses.add(new GetOneScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getAuthor(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            ));
        }
        responses.sort((a,b)->b.getModifiedAt().compareTo(a.getModifiedAt()));
        return responses;
    }

    @Transactional
    public UpdateScheduleResponse update(Long userId, UpdateScheduleRequest updateScheduleRequest) {

        Schedule schedule = scheduleRepository.findById(userId).orElseThrow(
                ()->new IllegalStateException("존재하지 않는 id입니다.")
        );

        schedule.update(
                updateScheduleRequest.getTitle(),
                updateScheduleRequest.getContent(),
                updateScheduleRequest.getAuthor(),
                updateScheduleRequest.getPassword()
        );

        return new UpdateScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getAuthor(),
                schedule.getPassword()
        );
    }

    @Transactional
    public void delete(long userId) {
        boolean exists = scheduleRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("존재하지 않는 id입니다.");
        }
        scheduleRepository.deleteById(userId);
    }
}