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
        CreateScheduleResponse createUserResponse = scheduleService.save(createScheduleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponse);
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
// PathVariable - 경로변수
//PathVariable이 아니면 똑같은 url임

    @PutMapping("/schedules/{userId}")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(@PathVariable Long userId, @RequestBody UpdateScheduleRequest updateScheduleRequest) {
        UpdateScheduleResponse update = scheduleService.update(userId, updateScheduleRequest);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @DeleteMapping("/schedules/{userId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable long userId) {
        scheduleService.delete(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
