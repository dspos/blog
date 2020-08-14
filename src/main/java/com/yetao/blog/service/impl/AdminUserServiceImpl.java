package com.yetao.blog.service.impl;

import com.yetao.blog.mapper.AdminUserMapper;
import com.yetao.blog.mapper.RefreshTokenMapper;
import com.yetao.blog.pojo.Admin;
import com.yetao.blog.pojo.RefreshToken;
import com.yetao.blog.service.AdminUserService;
import com.yetao.blog.utils.*;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * @author YETAO
 * @Description
 * @date 2020/7/31 17:16
 */
@Slf4j
@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RefreshTokenMapper refreshTokenMapper;


    @Override
    public Result initAdmin(Admin admin, HttpServletRequest request) {
        if (adminUserMapper.getAdminCount() > 0) {
            return new Result(StatusCode.ERROR, "管理员已经初始化完成了！");
        }
        //检查数据
        if (StringUtils.isEmpty(admin.getUsername())) {
            return new Result(StatusCode.ERROR,"用户名不能为空！");
        }
        if (StringUtils.isEmpty(admin.getPassword())) {
            return new Result(StatusCode.ERROR,"密码不能为空！");
        }
        if (StringUtils.isEmpty(admin.getEmail())) {
            return new Result(StatusCode.ERROR,"邮箱不能为空！");
        }
        admin.setId(idWorker.nextId() + "");
        admin.setAvatar("嘻嘻");
        admin.setSign("有志者事竟成");
        admin.setLoginIp(IpUtil.getIpAddress(request));
        admin.setCreateTime(new Date());
        admin.setUpdateTime(new Date());
        admin.setPassword(Md5Util.md5(admin.getPassword()));
        if (adminUserMapper.initAdmin(admin) > 0) {
            return new Result(StatusCode.OK, "管理员账号初始化成功！");
        }
        return new Result(StatusCode.OK, "管理员账号初始化失败！");
    }

    @Override
    public Result getAdminById(HttpServletRequest request, Integer id) {
        String tokenKey = CookieUtil.getCookie(request, "blog_token");
        if (tokenKey == null) {
            return new Result(StatusCode.ERROR, "账号未登录");
        }
        String token = (String) redisUtil.get(tokenKey);
        if (token == null) {

        }
        try {
            Claims claims = JwtUtil.parseJWT(token);
            System.out.println(claims);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //从数据库中获取信息
        Admin admin = adminUserMapper.getAdminById(id);
        //判断是否存在
        if (admin == null) {
            return new Result(StatusCode.ERROR, "用户不存在");
        }
        //返回结果
        admin.setPassword(null);
        return new Result(StatusCode.OK, "获取管理员信息成功", admin);
    }

    @Override
    public Result login(String captcha, String captchaKey, Admin admin, HttpServletRequest request, HttpServletResponse response) {
        //校验验证码
        String captchaValue = (String) redisUtil.get(captchaKey);
        if (!captcha.equals(captchaValue)) {
            return new Result(StatusCode.ERROR, "验证码错误！");
        }
        if (StringUtils.isEmpty(admin.getUsername())) {
            return new Result(StatusCode.ERROR, "用户名不能为空！");
        }
        if (StringUtils.isEmpty(admin.getPassword())) {
            return new Result(StatusCode.ERROR, "密码不能为空！");
        }

        String username = admin.getUsername();
        String password = admin.getPassword();
        Admin admin1 = adminUserMapper.checkUser(username, Md5Util.md5(password));
        if (admin1 != null) {
            Map<String, Object> claims = ClaimsUtil.admin2Claims(admin1);
            System.out.println(claims);
            String token = JwtUtil.createToken(claims);

            Claims claims1 = JwtUtil.parseJWT(token);
            System.out.println(ClaimsUtil.claims2Admin(claims1));
            //保存到redis
            String tokenKey = DigestUtils.md5DigestAsHex(token.getBytes());
            redisUtil.set(tokenKey, token, 60 * 60 * 2);
            //保存到cookie
            CookieUtil.setUpCookie(response, "blog_token", tokenKey);
            //生成refreshToken
            String refreshTokenValue = JwtUtil.createRefreshToken(String.valueOf(admin.getId()), 60 * 60 * 24 * 30);
            RefreshToken refreshToken = new RefreshToken();
            refreshToken.setId(idWorker.nextId() + "");
            refreshToken.setUserId(admin1.getId());
            refreshToken.setTokenKey(tokenKey);
            refreshToken.setRefreshToken(refreshTokenValue);
            refreshToken.setCreateTime(new Date());
            refreshToken.setUpdateTime(new Date());
            refreshTokenMapper.saveToken(refreshToken);
            return new Result(StatusCode.OK, "登录成功！");
        }
        return new Result(StatusCode.ERROR, "用户名或密码错误！");
    }

    @Override
    public Result updateAdminInfo(Admin admin) {
        Admin admin1 = new Admin();
        admin1.setId(admin.getId());
        admin1.setEmail(admin.getEmail());
        admin1.setAvatar(admin.getAvatar());
        admin1.setSign(admin.getSign());
        admin1.setUpdateTime(new Date());
        if (adminUserMapper.updateAdmin(admin1) > 0) {
            return new Result(StatusCode.OK, "修改信息成功！");
        }
        return new Result(StatusCode.ERROR, "修改信息失败");
    }
}
