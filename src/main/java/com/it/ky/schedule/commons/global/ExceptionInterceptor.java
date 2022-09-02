package com.it.ky.schedule.commons.global;

import com.it.ky.schedule.entity.ReturnData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ReturnData parseException(HttpServletRequest request, Exception e){
        return new ReturnData(false, e.getMessage(), null);
    }
}
