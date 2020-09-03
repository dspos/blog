package com.yetao.blog.utils;

import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YETAO
 * @Description
 * @date 2020/7/30 15:39
 */

@Data
public class Result {

    private Integer status;
    private String msg;
    private Object data;

    private Result() {
    }

    public static Result build() {
        return new Result();
    }

    public static Result ok(String msg, Object data) {
        return new Result(200, msg, data);
    }

    public static Result ok(String msg) {
        return new Result(200, msg, null);
    }

    public static Result error(String msg, Object data) {
        return new Result(500, msg, data);
    }

    public static Result error(String msg) {
        return new Result(500, msg, null);
    }

    private Result(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static Result getResult(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return Result.error("新增失败", map);
        }
        return null;
    }
}
