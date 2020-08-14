package com.yetao.blog.mapper;

import com.yetao.blog.pojo.Admin;

/**
 * @author YETAO
 * @Description
 * @date 2020/7/31 16:52
 */

public interface AdminUserMapper {


    /**
     * 查询表中是否有管理员信息
     * @return
     */
    int getAdminCount();

    /**
     * 初始化账号
     * @param admin
     * @return
     */
    int initAdmin(Admin admin);


    /**
     * 获取管理员信息
     * @param id
     * @return
     */
    Admin getAdminById(Integer id);

    /**
     * 修改管理员信息
     * @param admin
     * @return
     */
    int updateAdmin(Admin admin);

    /**
     * 查询用户名密码
     * @param username
     * @param password
     * @return
     */
    Admin checkUser(String username, String password);
}
