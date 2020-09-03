package com.yetao.blog.controller;


import com.yetao.blog.entity.Admin;
import com.yetao.blog.service.AdminUserService;
import com.yetao.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @Author yetao
 * @Date 2020/8/27 17:18
 * @Description 管理员controller
 */
@RestController
@RequestMapping("admin")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 初始化管理员账号
     * @param admin
     * @return
     */
    @PostMapping("init")
    public Result initAdmin(@Valid @RequestBody Admin admin, BindingResult bindingResult, HttpServletRequest request) {
        Result result = Result.getResult(bindingResult);
        if (result != null) {
            return result;
        }
        return adminUserService.initAdmin(admin, request);
    }

    /**
     * 管理员登录
     * @return
     */
    @PostMapping("login")
    public Result login(@RequestBody Admin admin, HttpServletResponse response,
                        @RequestParam("captcha_key") String captchaKey,
                        @RequestParam("captcha_value") String captchaValue) {
        return adminUserService.login(admin, response, captchaKey, captchaValue);
    }

    /**
     * 获取管理员信息
     * @param id
     * @return
     */
    @GetMapping
    public Result getAdminById(@RequestParam("id") Long id) {
        return adminUserService.getAdminById(id);
    }

    /**
     * 修改管理员信息
     * @param admin
     * @return
     */
    @PutMapping("{id}")
    public Result updateAdminById(@PathVariable("id") Long id ,@RequestBody Admin admin) {
        return adminUserService.updateAdminById(id, admin);
    }


    /**
     * 管理员退出登录
     * @return
     */
    public Result logout() {
        return null;
    }
}

