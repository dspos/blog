package com.yetao.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/13 21:15
 */
@Data
public class RefreshToken {

    private String id;

    private String userId;

    private String tokenKey;

    private String refreshToken;

    private Date createTime;

    private Date updateTime;
}
