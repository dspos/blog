package com.yetao.blog.service;

import com.yetao.blog.entity.Label;
import com.yetao.blog.utils.Result;

/**
 * @Author yetao
 * @Date 2020/9/3 10:58
 * @Description 标签service
 */

public interface AdminLabelService {
    
    Result addLabel(Label label);

    Result deleteLabel(Long id);

    Result updateLabel(Long id, Label label);

    Result findLabelById(Long id);

    Result findAllLabel();
}
