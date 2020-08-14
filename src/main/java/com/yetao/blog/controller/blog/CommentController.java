package com.yetao.blog.controller.blog;

import com.yetao.blog.pojo.Comment;
import com.yetao.blog.utils.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/1 16:22
 */
@RestController
@RequestMapping("blog/comment")
public class CommentController {

    @PostMapping
    public Result addComment(@RequestBody Comment comment) {
        return null;
    }

    @DeleteMapping("{commentId}")
    public Result delComment(@PathVariable("commentId") String commentId) {
        return null;
    }

    @GetMapping("list/{articleId}")
    public Result listComments(@PathVariable("articleId") String articleId) {
        return null;
    }

}
