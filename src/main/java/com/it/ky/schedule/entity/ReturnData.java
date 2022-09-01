package com.it.ky.schedule.entity;

import lombok.Data;

/**
 * @author 出参封装类
 */
@Data
public class ReturnData<T> {

    private boolean result;
    private String msg;
    private T data;

    public ReturnData() {
    }

    public ReturnData(boolean result, String msg, T data) {
        this.result = result;
        this.msg = msg;
        this.data = data;
    }

    public ReturnData(T data) {
        this.result = true;
        this.msg = "接收成功";
        this.data = data;
    }
}
