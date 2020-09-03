package com.yetao.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author YETAO
 * @Description
 * @date 2020/7/30 21:04
 */

@Data
@TableName("tb_label")
public class Label implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @NotNull(message = "标签名称不能为空")
    private String name;

    @NotNull(message = "标签拼音不能为空")
    private String pinyin;

    private Integer sort;

    @TableLogic
    private String status;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
