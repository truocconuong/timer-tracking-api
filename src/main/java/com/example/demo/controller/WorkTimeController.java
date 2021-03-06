package com.example.demo.controller;

import com.example.demo.auth.ReqUser;
import com.example.demo.entity.User;
import com.example.demo.entity.WorkTimes;
import com.example.demo.service.WorkTimeService;
import com.example.demo.service.contract.DTOBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/work-times")
public class WorkTimeController {
    @Autowired
    DTOBuilderService dtoBuilderService;

    @Autowired
    WorkTimeService workTimeService;


    @PostMapping()
    public ResponseEntity<WorkTimes> checkin(@RequestBody WorkTimes worktimes, @ReqUser User user) {
        System.out.println(user);
        System.out.println(worktimes);
        workTimeService.checkin(worktimes, user);
        return ResponseEntity.ok(worktimes);
    }


    @GetMapping()
    public ResponseEntity<List<WorkTimes>> getHistory(@ReqUser User user) {
       List<WorkTimes> workTimes = workTimeService.getHistory();
        return ResponseEntity.ok(workTimes);
    }
}
