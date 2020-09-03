package com.yetao.blog.service;

import com.yetao.blog.entity.Category;
import com.yetao.blog.utils.Result;

/**
 * @Author yetao
 * @Date 2020/9/2 18:34
 * @Description 分类service
 */

public interface AdminCategoryService {

    Result addCategory(Category category);

    Result deleteCategory(Long id);

    Result updateCategory(Long id, Category category);

    Result findCategoryById(Long id);

    Result findCategoryAll();
}
