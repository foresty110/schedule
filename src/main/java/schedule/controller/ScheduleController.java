package schedule.controller;

import java.util.List;

import schedule.dto.*;
import schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest createScheduleRequest) {
        CreateScheduleResponse createScheduleResponse = scheduleService.save(createScheduleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createScheduleResponse);
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<GetOneScheduleResponse> getSchedule(@PathVariable long id) {
        GetOneScheduleResponse one = scheduleService.getOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(one);
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<GetOneScheduleResponse>> getAllSchedule(@RequestParam(required = false) String author) {
        List<GetOneScheduleResponse> all = scheduleService.getAll(author);
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

    @PutMapping("/schedules/{id}")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(@PathVariable Long id, @RequestBody UpdateScheduleRequest request) {
        UpdateScheduleResponse update = scheduleService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable long id, @RequestBody String password) {
        scheduleService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //직렬화 - 역직렬화
    // 다른 객체를 우리 객체로 만들때 직렬화한다
    //json -> java 직렬화
    //java -> db 또는 json으로 만들떄 역직렬화

    //직렬화 방식: 파라미터 순서대로 생성자에 넣어주기
    //빈 객체륾 만들어서 setter로 넣어주기

    //한개짜리는 생성자를 만들어 넣어줘야

}
