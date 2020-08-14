package com.yetao.blog.mapper;

import com.yetao.blog.pojo.Category;

import java.util.List;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/7 16:52
 */

public interface AdminCategoryMapper {

    /**
     * 查询所有分类
     * @return
     */
    List<Category> getAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Category findById(Integer id);

    /**
     * 添加分类
     * @param category
     * @return
     */
    int addCategory(Category category);

    /**
     * 根据id删除分类
     * @param id
     * @return
     */
    int deleteCategoryById(Integer id);

    /**
     * 更新分类
     * @param category
     * @return
     */
    int updateCategory(Category category);
}
