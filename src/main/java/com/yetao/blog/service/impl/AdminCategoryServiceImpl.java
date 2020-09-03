package com.yetao.blog.service.impl;

import com.yetao.blog.mapper.AdminCategoryMapper;
import com.yetao.blog.entity.Category;
import com.yetao.blog.service.AdminCategoryService;
import com.yetao.blog.utils.Message;
import com.yetao.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yetao
 * @Date 2020/9/2 18:35
 * @Description 文章分类service
 */

@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {

    @Autowired
    private AdminCategoryMapper adminCategoryMapper;

    @Override
    public Result addCategory(Category category) {
        category.setStatus("0");
        adminCategoryMapper.insert(category);
        return Result.ok(Message.INSERT);
    }

    @Override
    public Result deleteCategory(Long id) {
        adminCategoryMapper.deleteById(id);
        return Result.ok(Message.DELETE);
    }

    @Override
    public Result updateCategory(Long id, Category category) {
        category.setId(id);
        adminCategoryMapper.updateById(category);
        return Result.ok(Message.UPDATE);
    }

    @Override
    public Result findCategoryById(Long id) {
        return Result.ok(Message.SELECT, adminCategoryMapper.selectById(id));
    }

    @Override
    public Result findCategoryAll() {
        return Result.ok(Message.SELECT, adminCategoryMapper.selectList(null));
    }
}
