package com.yetao.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author YETAO
 * @Description
 * @date 2020/7/30 20:44
 */

@Data
public class Article {

    private String id;

    private String title;

    private String userId;

    private String userAvatar;

    private String categoryId;

    private String content;

    private String type;

    private String state;

    private String summary;

    private String labels;

    private String viewCount;

    private Date createTime;

    private Date updateTime;
}
