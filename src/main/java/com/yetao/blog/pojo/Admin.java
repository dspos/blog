package com.yetao.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/6 13:53
 */

@Data
public class Admin {

    private String id;

    private String username;

    private String password;

    private String email;

    private String avatar;

    private String sign;

    private String loginIp;

    private Date createTime;

    private Date updateTime;
}
