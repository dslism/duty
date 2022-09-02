package com.it.ky.schedule.controller;

import com.it.ky.schedule.entity.ReturnData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/duty")
public class DutyController {

    @GetMapping("/autoDuty")
    public ReturnData autoDuty(){

    }

    // 手动排班
    @PostMapping("/manualDuty")
    public ReturnData manualDuty(){

    }
    // 请假
    @PostMapping("/rest")
    public ReturnData rest(){

    }
    // 申请换班
    @PostMapping("/changeDuty")
    public ReturnData changeDuty(){

    }
    // 上班打卡
    @PostMapping("/sign")
    public ReturnData sign(){

    }
}
