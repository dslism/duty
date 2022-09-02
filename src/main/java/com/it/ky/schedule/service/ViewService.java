package com.it.ky.schedule.service;

import com.it.ky.schedule.entity.ReturnData;

public interface ViewService {
//    获取当前时间的值班人
    ReturnData gerCurDutyPerson();
//获取值班日历
    ReturnData getDutyCalendar();
// 获取值班日志
    ReturnData getDutyLogs();

}
