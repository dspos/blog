package com.yetao.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author YETAO
 * @Description
 * @date 2020/7/30 21:04
 */

@Data
public class Label {

    private String id;

    private String name;

    private Integer count;

    private Date createTime;

    private Date updateTime;
}
