package com.it.ky.schedule.service.impl;

import com.it.ky.schedule.entity.Pwd;
import com.it.ky.schedule.mapper.PwdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PwdServiceImpl {
    @Resource
    private PwdMapper pwdMapper;

    public Pwd LoginIn(String name, String password) {
        Pwd info = PwdMapper.getInfo(name, password);
        return info;
    }

}


