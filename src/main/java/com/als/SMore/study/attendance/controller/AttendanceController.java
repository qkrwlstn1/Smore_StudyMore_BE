package com.als.SMore.study.attendance.controller;

import com.als.SMore.study.attendance.DTO.request.LearningMonthRequestDTO;
import com.als.SMore.study.attendance.DTO.response.LearningMonthListResponseDTO;
import com.als.SMore.study.attendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/study")
@RequiredArgsConstructor
public class AttendanceController {
    final private AttendanceService attendanceService;



    private Long getMember(){

        return 588968050131947446L;
    }

    @PostMapping("/{studyPk}/attendance/start")
    public LocalDateTime start(@PathVariable Long studyPk){
        return attendanceService.attendanceStart(getMember(), studyPk);
    }

    @PostMapping("/{studyPk}/attendance/stop")
    public Long end(@PathVariable Long studyPk){
       return attendanceService.attendanceEnd(getMember(), studyPk);
    }

    @GetMapping("/{studyPk}/attendance/my-study-time")
    public Long getTime(@PathVariable Long studyPk){
        return attendanceService.getLearningSeconds(getMember(), studyPk);
    }

    @GetMapping("/{studyPk}/attendance/my-study-month")
    public LearningMonthListResponseDTO getMonth(@PathVariable Long studyPk, @RequestBody LearningMonthRequestDTO learningMonthRequestDTO){
        System.out.println(learningMonthRequestDTO.getMonth());
        return attendanceService.getLearningMonth(getMember(), studyPk, learningMonthRequestDTO);

    }

}
