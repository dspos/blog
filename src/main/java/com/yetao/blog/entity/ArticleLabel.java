package com.yetao.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Author yetao
 * @Date 2020/9/3 17:14
 * @Description TODO
 */

@Data
@TableName("tb_article_label")
public class ArticleLabel {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long articleId;

    private Long labelId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
