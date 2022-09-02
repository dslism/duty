package com.it.ky.schedule.commons.global;

public class ServiceException extends Exception{
    private String msg;

    public ServiceException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
