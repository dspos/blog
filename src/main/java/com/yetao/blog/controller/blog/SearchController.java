package com.yetao.blog.controller.blog;

import com.yetao.blog.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/1 16:55
 */

@RestController
@RequestMapping("blog/search")
public class SearchController {

    @GetMapping
    public Result doSearch(@RequestParam("keyword") String keyword, @RequestParam("page") int size) {
        return null;
    }
}
