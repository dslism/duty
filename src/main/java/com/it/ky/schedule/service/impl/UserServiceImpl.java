package com.it.ky.schedule.service.impl;

import com.it.ky.schedule.entity.DutyUser;
import com.it.ky.schedule.entity.ReturnData;
import com.it.ky.schedule.entity.User;
import com.it.ky.schedule.mapper.PwdMapper;
import com.it.ky.schedule.mapper.UserMapper;
import com.it.ky.schedule.service.UserService;
import com.it.ky.schedule.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author: yangchangkui
 * @date: 2018-11-03 10:43
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    PwdMapper pwdMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public List<String> getDutyUserEmails() {
        String currDate = DateUtil.getCurrDate("yyyy-MM-dd");
        return userMapper.queryDutyUserEmails(currDate);
    }

    @Override
    public ReturnData getAllDutyUser() {

        List<Map> mapList = userMapper.queryAllDutyUser();

        ReturnData baseResponse = new ReturnData();
        baseResponse.setData(mapList);

        return baseResponse;
    }

    @Override
    public ReturnData saveUser(User model) {
        userMapper.insert(model);

//        int line = userMapper.insertUser(model);

        return new ReturnData(model);
    }

    @Override
    public int batchDutyUser(int id, String strDate) {
        int line = 0;
        DutyUser dutyUser = userMapper.queryDutyUser(id,strDate);
        if(dutyUser != null){
            line = userMapper.updateDutyUser(id,strDate);
        }else{
            line = userMapper.insertDutyUser(id,strDate);
        }
        return line;
    }
}
