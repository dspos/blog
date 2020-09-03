package com.yetao.blog.service;

import com.yetao.blog.entity.Admin;
import com.yetao.blog.utils.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author yetao
 * @Date 2020/8/27 17:18
 * @Description 管理员service
 */
public interface AdminUserService {

    Result initAdmin(Admin admin, HttpServletRequest request);

    Result login(Admin admin, HttpServletResponse response, String captchaKey, String captchaValue);

    Result getAdminById(Long id);

    Result updateAdminById(Long id, Admin admin);
}
