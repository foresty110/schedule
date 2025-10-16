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
        System.out.println("Create Schedule Request");
        CreateScheduleResponse createUserResponse = scheduleService.save(createScheduleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponse);
    }

    @GetMapping("/schedules/{userId}")
    public ResponseEntity<GetOneScheduleResponse> getSchedule(@PathVariable long userId) {
        GetOneScheduleResponse one = scheduleService.getOne(userId);
        return ResponseEntity.status(HttpStatus.OK).body(one);
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<GetOneScheduleResponse>> getAllSchedule() {
        List<GetOneScheduleResponse> all = scheduleService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

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
