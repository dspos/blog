package com.yetao.blog.controller.blog;

import com.yetao.blog.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/1 16:39
 */

@RestController
@RequestMapping("blog/web_size")
public class WebSizeController {

    @GetMapping("categories")
    public Result getCategories() {
        return null;
    }

    @GetMapping("title")
    public Result getWebSizeTitle() {
        return null;
    }

    @GetMapping("view_count")
    public Result getWebSizeViewCount() {
        return null;
    }

    @GetMapping("seo")
    public Result getWebSizeSeo() {
        return null;
    }

    @GetMapping("looper")
    public Result getWebSizeLooper() {
        return null;
    }

    @GetMapping("friend_link")
    public Result getFriendLinks() {
        return null;
    }
}
