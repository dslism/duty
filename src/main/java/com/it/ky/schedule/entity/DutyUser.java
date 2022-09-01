package com.it.ky.schedule.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author: yangchangkui
 * @date: 2018-11-16 19:45
 */
@Data
@TableName()
public class DutyUser {
    private int id;
    private int userId;
    private Date dutyDate;
    private String remark;
    private String createBy;
    private Date createDate;
}
