package com.it.ky.schedule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.ky.schedule.entity.EmailInfo;
import com.it.ky.schedule.entity.Pwd;
import com.it.ky.schedule.entity.User;
import org.apache.ibatis.annotations.Mapper;
import com.it.ky.schedule.entity.Pwd;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface PwdMapper  {
    //查询，可以实现登录功能
    @Select("SELECT * FROM user WHERE name = #{name} AND password = #{password}")
    static Pwd getInfo(@Param("name") String name, @Param("pwd") String password);


}


