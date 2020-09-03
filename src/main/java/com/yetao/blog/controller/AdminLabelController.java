package com.yetao.blog.controller;

import com.yetao.blog.entity.Label;
import com.yetao.blog.service.AdminLabelService;
import com.yetao.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author yetao
 * @Date 2020/9/3 10:56
 * @Description 标签controller
 */

@RestController
@RequestMapping("admin/label")
public class AdminLabelController {

    @Autowired
    private AdminLabelService adminLabelService;

    /**
     * 添加标签
     * @param label
     * @return
     */
    @PostMapping
    public Result addLabel(@Valid @RequestBody Label label, BindingResult bindingResult) {
        Result result = Result.getResult(bindingResult);
        if (result != null) {
            return result;
        }
        return adminLabelService.addLabel(label);
    }

    /**
     * 删除标签
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public Result deleteLabel(@PathVariable("id") Long id) {
        return adminLabelService.deleteLabel(id);
    }

    /**
     * 修改标签
     * @param id
     * @param label
     * @return
     */
    @PutMapping("{id}")
    public Result updateLabel(@PathVariable("id")Long id, @RequestBody Label label) {
        return adminLabelService.updateLabel(id, label);
    }

    /**
     * 根据id查询标签
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result findLabelById(@PathVariable("id") Long id) {
        return adminLabelService.findLabelById(id);
    }

    /**
     * 查询所有标签
     * @return
     */
    @GetMapping
    public Result findAllLabel() {
        return adminLabelService.findAllLabel();
    }
}
