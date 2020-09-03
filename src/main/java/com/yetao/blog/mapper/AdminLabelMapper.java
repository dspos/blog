package com.yetao.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yetao.blog.entity.Label;

/**
 * @Author yetao
 * @Date 2020/9/3 11:04
 * @Description 标签mapper
 */

public interface AdminLabelMapper extends BaseMapper<Label> {

    Label selectByLabelName(String name);
}
