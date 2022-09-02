package com.it.ky.schedule.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yangchangkui
 */
@Data
@TableName("pwd")
public class Pwd {
    private int id;
    private String name;
    private String pwd;
//    0是员工，1 是管理员
    private int level;
}
