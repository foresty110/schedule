package schedule.controller;

import java.util.List;

import schedule.dto.*;
import schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/* ScheduleController
 * ---------------------------
 * 일정 관련 REST API를 처리하는 컨트롤러 클래스입니다. */
@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService; // 일정 비즈니스 로직을 수행하는 서비스

    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest createScheduleRequest) {

        if (createScheduleRequest.getContent() == null ||
                createScheduleRequest.getAuthor() == null ||
                createScheduleRequest.getPassword() == null){
            throw new IllegalStateException("필수 입력값 누락");
        }

        CreateScheduleResponse createScheduleResponse = scheduleService.save(createScheduleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createScheduleResponse);
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<GetOneScheduleResponse> getSchedule(@PathVariable long id) {
        GetOneScheduleResponse one = scheduleService.getOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(one);
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<GetAllScheduleResponse>> getAllSchedule(@RequestParam(required = false) String author) {
        List<GetAllScheduleResponse> all = scheduleService.getAll(author);
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

    @PutMapping("/schedules/{id}")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(@PathVariable Long id, @RequestBody UpdateScheduleRequest request) {
        UpdateScheduleResponse update = scheduleService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable long id, @RequestBody String password) {
        scheduleService.delete(id,password);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
