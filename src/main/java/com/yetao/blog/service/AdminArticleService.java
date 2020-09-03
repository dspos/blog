package com.yetao.blog.service;

import com.yetao.blog.entity.Article;
import com.yetao.blog.utils.Result;

/**
 * @Author yetao
 * @Date 2020/9/3 14:35
 * @Description TODO
 */

public interface AdminArticleService {

    Result addArticle(Article article);

    Result deleteArticle(Long id);

    Result updateArticle(Long id, Article article);

    Result findArticleById(Long id);

    Result findArticleAll();
}
