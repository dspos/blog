package com.yetao.blog.controller.blog;

import com.yetao.blog.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/1 16:38
 */

@RestController
@RequestMapping("blog/article")
public class ArticleController {

    @GetMapping("list/{page}/{size}")
    public Result listArticles(@PathVariable("page") int page, @PathVariable("size") int size) {
        return null;
    }

    @GetMapping("list/{categoryId}/{page}/{size}")
    public Result listArticleByCategoryId(@PathVariable("categoryId") String categoryId,
                                          @PathVariable("page") int page,
                                          @PathVariable("size") int size) {
        return null;
    }

    @GetMapping("{articleId}")
    public Result getArticleDetail(@PathVariable("articleId") String articleId) {
        return null;
    }

    @GetMapping("recommend/{articleId}")
    public Result getRecommendArticle(@PathVariable("articleId") String articleId) {
        return null;
    }
}
