package com.yetao.blog.controller.admin;

import com.yetao.blog.pojo.Admin;
import com.yetao.blog.service.AdminUserService;
import com.yetao.blog.utils.Result;
import com.yetao.blog.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YETAO
 * @Description 管理员controller
 * @date 2020/7/30 17:00
 */

@Slf4j
@RestController
@RequestMapping("admin")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 初始化账号
     * @return
     */
    @PostMapping("init_account")
    public Result initAccount(@RequestBody Admin admin, HttpServletRequest request) {
        return adminUserService.initAdmin(admin, request);
    }

    /**
     * 用户登录
     * @param captcha
     * @param admin
     * @param request
     * @param response
     * @return
     */
    @PostMapping("login")
    public Result login(@RequestParam("captcha") String captcha,
                        @RequestParam("captcha_key") String captchaKey,
                        @RequestBody Admin admin,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        return adminUserService.login(captcha, captchaKey, admin, request, response);
    }

    /**
     * 修改密码
     * @return
     */
    @PutMapping("password/{userId}")
    public Result changePassword(@PathVariable("userId") String userId, @RequestBody Admin admin) {
        return new Result(StatusCode.OK, "修改密码成功");
    }

    /**
     * 发送邮件
     * @return
     */
    @GetMapping("verify_code")
    public Result sendVerifyCode(@RequestParam("email") String email) {
        log.info("email ==> " + email);
        return new Result(StatusCode.OK, "发送邮件成功");
    }

    /**
     * 获取管理员信息
     * @return
     */
    @GetMapping("{id}")
    public Result getUserInfo(HttpServletRequest request, @PathVariable("id") Integer id) {
        return adminUserService.getAdminById(request,id);
    }

    /**
     * 修改管理员信息
     * @return
     */
    @PutMapping("update_info")
    public Result updateAdminInfo(@RequestBody Admin admin) {
        return adminUserService.updateAdminInfo(admin);
    }
}
