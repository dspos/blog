package com.yetao.blog.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import com.yetao.blog.utils.RedisUtil;
import com.yetao.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/12 9:28
 */
@RestController
public class CaptchaController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("captcha1")
    public Result getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();
        String key = IdWorker.getIdStr();
        redisUtil.set(key, verCode, 60 * 10 * 3);
        Map<String, Object> map = new HashMap<>();
        map.put("key", key);
        map.put("image", specCaptcha.toBase64());
        return Result.ok("获取验证码成功！", map);
    }

    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置请求头为输出图片类型
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 三个参数分别为宽、高、位数
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        // 设置字体
        specCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));  // 有默认字体，可以不用设置
        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);

        // 验证码存入session
        request.getSession().setAttribute("captcha", specCaptcha.text().toLowerCase());
        redisUtil.set(IdWorker.getIdStr(), specCaptcha.text().toLowerCase());

        // 输出图片流
        specCaptcha.out(response.getOutputStream());
    }

}
