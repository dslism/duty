package com.it.ky.schedule.service;

import com.it.ky.schedule.entity.ReturnData;

public interface DutyService {

// 自动排班
    ReturnData autoDuty();
// 手动排班
    ReturnData manualDuty();
// 请假
    ReturnData rest();
// 申请换班
    ReturnData changeDuty();
// 上班打卡
    ReturnData sign();
}
