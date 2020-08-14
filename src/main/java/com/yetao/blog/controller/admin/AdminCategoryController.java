package com.yetao.blog.controller.admin;

import com.yetao.blog.pojo.Category;
import com.yetao.blog.utils.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author YETAO
 * @Description 分类controller
 * @date 2020/8/1 14:56
 */

@RestController
@RequestMapping("admin/category")
public class AdminCategoryController {


    /**
     * 添加分类
     * @param category
     * @return
     */
    @PostMapping
    public Result addCategory(@RequestBody Category category) {
        return null;
    }

    /**
     * 删除分类
     * @param categoryId
     * @return
     */
    @DeleteMapping("{categoryId}")
    public Result delCategory(@PathVariable("categoryId") String categoryId) {
        return null;
    }

    /**
     * 修改分类
     * @param category
     * @return
     */
    @PutMapping("{categoryId}")
    public Result updateCategory(@PathVariable("categoryId") String categoryId, @RequestBody Category category) {
        return null;
    }

    /**
     * 根据id查询分类
     * @param categoryId
     * @return
     */
    @GetMapping("{categoryId}")
    public Result getCategory(@PathVariable("categoryId") String categoryId) {
        return null;
    }

    /**
     * 查询所有分类
     * @param page
     * @param size
     * @return
     */
    @GetMapping("list")
    public Result listCategories(@RequestParam("page") int page, @RequestParam("size") int size) {
        return null;
    }
}
