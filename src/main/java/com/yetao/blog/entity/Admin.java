package com.yetao.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author yetao
 * @Date 2020-08-27
 */

@Data
@TableName("tb_admin")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;

    @Email(message = "请输入正确的邮箱地址")
    private String email;

    private String sign;

    private String loginIp;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
