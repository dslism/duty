package com.it.ky.schedule.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yangchangkui
 */
@Data
@TableName("user")
public class User {
    private Integer id;
    private String name;
    private boolean sex;
    private String birthday;
    private String phone;
    private String email;
    private String address;
}
