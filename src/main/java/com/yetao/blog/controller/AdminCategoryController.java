package com.yetao.blog.controller;

import com.yetao.blog.entity.Category;
import com.yetao.blog.service.AdminCategoryService;
import com.yetao.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author yetao
 * @Date 2020/9/2 17:54
 * @Description 文章分类接口
 */

@RestController
@RequestMapping("admin/category")
public class AdminCategoryController {

    @Autowired
    private AdminCategoryService adminCategoryService;

    /**
     * 添加分类
     * @param category
     * @return
     */
    @PostMapping
    public Result addCategory(@Valid @RequestBody Category category, BindingResult bindingResult) {
        Result result = Result.getResult(bindingResult);
        if (result != null) {
            return result;
        }
        return adminCategoryService.addCategory(category);
    }


    /**
     * 删除分类
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public Result deleteCategory(@PathVariable("id") Long id) {
        return adminCategoryService.deleteCategory(id);
    }

    /**
     * 修改分类
     * @param id
     * @param category
     * @return
     */
    @PutMapping("{id}")
    public Result updateCategory(@PathVariable("id")Long id, @RequestBody Category category) {
        return adminCategoryService.updateCategory(id, category);
    }

    /**
     * 根据id查询分类
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result findCategoryById(@PathVariable("id") Long id) {
        return adminCategoryService.findCategoryById(id);
    }

    /**
     * 查询所有分类
     * @return
     */
    @GetMapping
    public Result findCategoryAll() {
        return adminCategoryService.findCategoryAll();
    }
}
