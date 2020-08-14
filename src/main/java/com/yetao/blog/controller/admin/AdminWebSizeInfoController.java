package com.yetao.blog.controller.admin;

import com.yetao.blog.utils.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/1 15:28
 */

@RestController
@RequestMapping("admin/web_size_info")
public class AdminWebSizeInfoController {

    @GetMapping("title")
    public Result getWebSizeTitle() {
        return null;
    }

    @PutMapping("title")
    public Result updateWebSizeTitle(@RequestParam("title") String title) {
        return null;
    }

    @GetMapping("seo")
    public Result getSeoInfo() {
        return null;
    }

    @PutMapping("seo")
    public Result updateSeoInfo(@RequestParam("keywords") String keywords, @RequestParam("description") String description) {
        return null;
    }

    @GetMapping("view_count")
    public Result getViewCount() {
        return null;
    }
}
