package com.yetao.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author YETAO
 * @Description
 * @date 2020/7/30 20:53
 */

@Data
public class Comment {

    private String id;

    private String parentContent;

    private String articleId;

    private String content;

    private String userId;

    private String userAvatar;

    private String userName;

    private String state;

    private Date createTime;

    private Date updateTime;
}
