package com.yetao.blog.controller.admin;

import com.yetao.blog.utils.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/1 15:29
 */

@RestController
@RequestMapping("admin/comment")
public class AdminCommentController {

    @DeleteMapping("{commentId}")
    public Result delComment(@PathVariable("commentId") String commentId) {
        return null;
    }

    @GetMapping("list")
    public Result listComment(@RequestParam("page") int page, @RequestParam("size") int size) {
        return null;
    }


    @PutMapping("top/{commentId}")
    public Result topComment(@PathVariable("commentId") String commentId) {
        return null;
    }
}
