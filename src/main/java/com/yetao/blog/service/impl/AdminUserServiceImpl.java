package com.yetao.blog.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.yetao.blog.mapper.AdminUserMapper;
import com.yetao.blog.entity.Admin;
import com.yetao.blog.service.AdminUserService;
import com.yetao.blog.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author yetao
 * @Date 2020/8/27 17:18
 * @Description 管理员service
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Result initAdmin(Admin admin, HttpServletRequest request) {
        if (StringUtils.isEmpty(admin.getUsername()) && StringUtils.isEmpty(admin.getPassword())) {
            return Result.error(Message.NOTNULL_NAME_PWD);
        }

        if (StringUtils.isEmpty(admin.getEmail())) {
            return Result.error(Message.NOTNULL_EMAIL);
        }
        if (adminUserMapper.selectCount(null) > 0) {
            return Result.error("账号已经初始化过了！");
        }

        admin.setPassword(Md5Util.md5(admin.getPassword()));
        admin.setLoginIp(IpUtil.getIpAddress(request));

        if (adminUserMapper.insert(admin) < 0) {
            return Result.error("管理员账号初始化失败");
        }
        return Result.ok("管理员账号初始化成功！");
    }

    @Override
    public Result login(Admin admin, HttpServletResponse response, String captchaKey, String captchaValue ) {
        if (!captchaValue.equals(redisUtil.get(captchaKey))) {
            return Result.error(Message.ERROR_CODE);
        }
        String username = admin.getUsername();
        String password = admin.getPassword();
        Admin loginAdmin = adminUserMapper.login(username, Md5Util.md5(password));
        if (loginAdmin == null) {
            return Result.error(Message.ERROR_NAME_PWD);
        }
        String token = JwtUtil.createJWT(IdWorker.getId(), username, null);
        response.addHeader("token", token);
        return Result.ok(Message.SUCCESS_LOGIN);
    }

    @Override
    public Result getAdminById(Long id) {
        return Result.ok(Message.SELECT, adminUserMapper.selectById(id));
    }

    @Override
    public Result updateAdminById(Long id, Admin admin) {
        admin.setId(id);
        return Result.ok(Message.SELECT, adminUserMapper.updateById(admin));
    }
}
