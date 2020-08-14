package com.yetao.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author YETAO
 * @Description
 * @date 2020/7/30 20:51
 */

@Data
public class Category {

    private String id;

    private String name;

    private String pinyin;

    private String description;

    private Integer order;

    private String status;

    private Date createTime;

    private Date updateTime;
}
