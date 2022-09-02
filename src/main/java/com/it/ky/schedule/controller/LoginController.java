package com.it.ky.schedule.controller;

import com.it.ky.schedule.entity.Pwd;
import com.it.ky.schedule.service.PwdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
@Slf4j
@Controller
public class LoginController {

    //将Service注入Web层
    @Resource
    PwdService PwdService;

    //实现登录
    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String name,String password){
        Pwd userBean = PwdService.LoginIn(name, password);
        log.info("name:{}",name);
        log.info("password:{}",password);
        if(userBean!=null){
            return "success";
        }else {
            return "error";
        }
    }

}


