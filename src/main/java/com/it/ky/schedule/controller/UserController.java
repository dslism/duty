package com.it.ky.schedule.controller;

import com.it.ky.schedule.entity.Pwd;
import com.it.ky.schedule.entity.ReturnData;
import com.it.ky.schedule.entity.User;
import com.it.ky.schedule.mapper.PwdMapper;
import com.it.ky.schedule.mapper.UserMapper;
import com.it.ky.schedule.service.UserService;
import com.it.ky.schedule.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;






/**
 * @author yangchangkui
 */
@RequestMapping("/user")
@RestController
public class UserController {


    @GetMapping("/test")
    public ReturnData test(){
        Pwd pwd = pwdMapper.selectById("1");
        return new ReturnData(pwd);
    }

//    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @GetMapping("/login")
    public String login(String username, String password) {
        if (username.equals(realUsername) && password.equals(realPassword)) {
            User u = new User();
            u.setPassword(password);
            u.setUsername(username);
            return JWTUtils.getToken(u);
        }
        return "登录失败！账号或者密码不对！";
    }


    /**
     * 获取所有人信息
     * @return
     */
    @RequestMapping("/getAllUser")
    public ReturnData getAllUser(){
        ReturnData response = new ReturnData();
        List<User> allUser = userService.getAllUser();
        response.setData(allUser);
        return response;
    }


    /**
     * 获取所有值日人员
     * @return
     */
    @RequestMapping("/getAllDutyUser")
    public ReturnData getAllDutyUser(){
        return userService.getAllDutyUser();
    }



    /**
     * 值日排班
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping("/scheduleDuty")
    public ReturnData scheduleDuty(@RequestParam String startDate, @RequestParam String endDate){
        //查询所有人
        List<User> allUser = userService.getAllUser();

        logger.debug("allUser:"+allUser);
        if(allUser == null || allUser.size() == 0){
            return new ReturnData("没有人可安排值日！");
        }
        List<String> dateList = new ArrayList<>();
        //只有开始时间，默认排完所有人，单人排
        if(StringUtils.isNotBlank(startDate) && StringUtils.isBlank(endDate)){
            dateList = DateUtil.getDateList(startDate, allUser.size());
            //两个时间都有
        }else if(StringUtils.isNotBlank(startDate) && StringUtils.isNotBlank(endDate)){
            dateList = DateUtil.getDateList(startDate, endDate);
        }

        //取小值
        int size = allUser.size() > dateList.size() ? dateList.size() : allUser.size();
        Map tempMap = new HashMap(size);
        for (int i = 0; i < size; i++) {
            //随机下标
            int index = (int) (Math.random() * allUser.size());
            User user = allUser.get(index);
            allUser.remove(index);
            String strDate = dateList.get(i);
            int line = userService.batchDutyUser(user.getId(),strDate);

            String dateKey = null;
            try {
                dateKey = DateUtil.getDate(DateUtils.parseDate(strDate,"yyyy-MM-dd"), "MM-dd-yyyy");
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String value = "<div class=\"fc-name\">"+user.getName()+"</div>";
            //排班完成
            tempMap.put(dateKey,value);
            //将排班结果保存或更新到数据库中



            }
        ReturnData response = new ReturnData();
            response.setData(tempMap);
            return response;
    }


    @Resource
    private JavaMailSender mailSender;

    /**
     * 发送邮件
     * String to, String subject, String content, String filePath
     * @return
     */
    @PostMapping("/sendEmail")
    public ReturnData sendEmail(@RequestBody Map<String,String> model){
        //TODO:邮件发送
        return null;
    }


    /**
     * 保存人员
     * @param model
     * @return
     */
    @RequestMapping("/saveUser")
    public ReturnData saveUser(@RequestBody User model){
        return userService.saveUser(model);
    }

    /**
     * 上传文件
     * @return
     */
    @RequestMapping("/uploadFile")
    public ReturnData uploadFile(@RequestParam("file") MultipartFile file,HttpServletRequest request, HttpServletResponse response){
        if(file.isEmpty()) {
            return new ReturnData("请选择文件");
        }
        //上传到upload目录下
        String fileName = "upload\\"+file.getOriginalFilename();
        String path = request.getSession().getServletContext().getRealPath("/");

        File dest = new File(path+fileName);
        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
            return new ReturnData(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return new ReturnData(false,"fail",e.getMessage());
        }
    }
}
