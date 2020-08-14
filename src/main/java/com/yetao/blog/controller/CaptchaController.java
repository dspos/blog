package com.yetao.blog.controller;

import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import com.yetao.blog.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.UUID;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/12 9:28
 */
@RestController
@RequestMapping("captcha")
public class CaptchaController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("get_captcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        //String verCode = specCaptcha.text().toLowerCase();
        //String key = UUID.randomUUID().toString();

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
        String key = UUID.randomUUID().toString();
        String verCode = specCaptcha.text().toLowerCase();
        //存入redis，并设置过期时间为30分钟
        //redisUtil.setEx(key, verCode, 30, TimeUnit.MINUTES);
        redisUtil.set(key, verCode, 60 * 10);
        // 输出图片流
        specCaptcha.out(response.getOutputStream());
    }

}
