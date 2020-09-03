package com.yetao.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author YETAO
 * @Description
 * @date 2020/7/30 20:44
 */

@Data
@TableName("tb_article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @NotNull(message = "标题不能为空")
    private String title;

    @NotNull(message = "摘要不能为空")
    private String summary;

    @NotNull(message = "内容不能为空")
    private String content;

    @NotNull(message = "分类id不能为空")
    private Long categoryId;

    @NotNull(message = "分类名称不能为空")
    private String categoryName;

    @NotNull(message = "标签不能为空")
    private String labels;

    private Integer sort;

    private Integer viewCount;

    @TableLogic
    private String status;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
