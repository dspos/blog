package com.yetao.blog.service;

import com.yetao.blog.pojo.Admin;
import com.yetao.blog.utils.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YETAO
 * @Description
 * @date 2020/7/31 17:15
 */

public interface AdminUserService {

    /**
     * 初始化账号
     * @param admin
     * @return
     */
    Result initAdmin(Admin admin, HttpServletRequest request);

    /**
     * 获取管理员信息
     * @param id
     * @return
     */
    Result getAdminById(HttpServletRequest request, Integer id);


    /**
     * 用户登录
     * @param captcha
     * @param admin
     * @param request
     * @param response
     * @return
     */
    Result login(String captcha, String captchaKey, Admin admin, HttpServletRequest request, HttpServletResponse response);

    /**
     * 修改管理员信息
     * @param admin
     * @return
     */
    Result updateAdminInfo(Admin admin);
}
