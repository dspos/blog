package com.yetao.blog.service.impl;

import com.yetao.blog.entity.Article;
import com.yetao.blog.entity.Category;
import com.yetao.blog.entity.Label;
import com.yetao.blog.mapper.AdminArticleMapper;
import com.yetao.blog.mapper.AdminCategoryMapper;
import com.yetao.blog.mapper.AdminLabelMapper;
import com.yetao.blog.service.AdminArticleService;
import com.yetao.blog.utils.Message;
import com.yetao.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yetao
 * @Date 2020/9/3 14:35
 * @Description TODO
 */

@Service
@Transactional
public class AdminArticleServiceImpl implements AdminArticleService {

    @Autowired
    private AdminArticleMapper adminArticleMapper;

    @Autowired
    private AdminCategoryMapper adminCategoryMapper;

    @Autowired
    private AdminLabelMapper adminLabelMapper;

    @Override
    public Result addArticle(Article article) {
        Category category = adminCategoryMapper.selectById(article.getCategoryId());
        if (null == category) {
            article.setCategoryId(0L);
            article.setCategoryName("默认分类");
        } else {
            article.setCategoryName(article.getCategoryName());
            article.setSort(article.getSort() + 1);
        }
        String[] labels = article.getLabels().split(",");
        if (labels.length > 6) {
            return Result.error("标签数量限制为6");
        }
        article.setStatus("0");
        if (adminArticleMapper.insert(article) > 0) {
            List<Label> insertLabelList = new ArrayList<>();
            List<Label> allLabelList = new ArrayList<>();
            for (int i = 0; i < labels.length; i++) {
                Label label = adminLabelMapper.selectByLabelName(labels[i]);
            }
        }

        return Result.ok(Message.INSERT);
    }

    @Override
    public Result deleteArticle(Long id) {
        return null;
    }

    @Override
    public Result updateArticle(Long id, Article article) {
        return null;
    }

    @Override
    public Result findArticleById(Long id) {
        return null;
    }

    @Override
    public Result findArticleAll() {
        return null;
    }
}
