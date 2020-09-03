package com.yetao.blog.controller;

import com.yetao.blog.entity.Article;
import com.yetao.blog.service.AdminArticleService;
import com.yetao.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author yetao
 * @Date 2020/9/3 14:34
 * @Description TODO
 */

@RestController
@RequestMapping("admin/article")
public class AdminArticleController {
    
    @Autowired
    private AdminArticleService adminArticleService;
    
    @PostMapping
    public Result addArticle(@Valid @RequestBody Article article, BindingResult bindingResult) {
        Result result = Result.getResult(bindingResult);
        if (result != null) {
            return result;
        }
        return adminArticleService.addArticle(article);
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public Result deleteArticle(@PathVariable("id") Long id) {
        return adminArticleService.deleteArticle(id);
    }

    /**
     * 修改分类
     * @param id
     * @param article
     * @return
     */
    @PutMapping("{id}")
    public Result updateArticle(@PathVariable("id")Long id, @RequestBody Article article) {
        return adminArticleService.updateArticle(id, article);
    }

    /**
     * 根据id查询分类
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result findArticleById(@PathVariable("id") Long id) {
        return adminArticleService.findArticleById(id);
    }

    /**
     * 查询所有分类
     * @return
     */
    @GetMapping
    public Result findArticleAll() {
        return adminArticleService.findArticleAll();
    }
}
