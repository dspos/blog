package com.yetao.blog.mapper;

import com.yetao.blog.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Author yetao
 * @Date 2020/8/27 17:18
 * @Description 管理员mapper
 */

public interface AdminUserMapper extends BaseMapper<Admin> {

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    Admin login(String username, String password);

}
