package com.yetao.blog.utils;

import lombok.Data;

/**
 * @author YETAO
 * @Description
 * @date 2020/7/30 15:39
 */

@Data
public class Result<T> {


    private Integer code;  //返回码
    private String message;//返回消息
    private T data;        //返回数据

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = (T)data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result() {
        this.code = StatusCode.OK;
        this.message = "执行成功";
    }
}
