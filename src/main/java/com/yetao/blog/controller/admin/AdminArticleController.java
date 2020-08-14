package com.yetao.blog.controller.admin;

import com.yetao.blog.pojo.Article;
import com.yetao.blog.utils.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author YETAO
 * @Description 文章管理
 * @date 2020/8/1 15:27
 */

@RestController
@RequestMapping("admin/article")
public class AdminArticleController {

    @PostMapping
    public Result addArticle(@RequestBody Article article) {
        return null;
    }

    @DeleteMapping("{articleId}")
    public Result delArticle(@PathVariable("articleId") String articleId) {
        return null;
    }

    @PutMapping("{articleId}")
    public Result updateArticle(@PathVariable("articleId") String articleId, @RequestBody Article article) {
        return null;
    }

    @GetMapping("{articleId}")
    public Result getArticle(@PathVariable("articleId") String articleId) {
        return null;
    }

    @GetMapping("list")
    public Result listArticle(@RequestParam("page") int page, @RequestParam("size") int size) {
        return null;
    }

    @PutMapping("state/{articleId}/{state}")
    public Result updateArticleState(@PathVariable("articleId") String articleId, @PathVariable("state") String state) {
        return null;
    }

    /**
     * 置顶文章
     * @param articleId
     * @return
     */
    @PutMapping("top/{articleId}")
    public Result updateArticleState(@PathVariable("articleId") String articleId) {
        return null;
    }
}
