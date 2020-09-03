package com.yetao.blog.service.impl;

import com.yetao.blog.mapper.AdminLabelMapper;
import com.yetao.blog.entity.Label;
import com.yetao.blog.service.AdminLabelService;
import com.yetao.blog.utils.Message;
import com.yetao.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yetao
 * @Date 2020/9/3 10:58
 * @Description 标签service
 */

@Service
public class AdminLabelServiceImpl implements AdminLabelService {

    @Autowired
    private AdminLabelMapper adminLabelMapper;

    @Override
    public Result addLabel(Label label) {
        label.setStatus("0");
        adminLabelMapper.insert(label);
        return Result.ok(Message.INSERT);
    }

    @Override
    public Result deleteLabel(Long id) {
        adminLabelMapper.deleteById(id);
        return Result.ok(Message.DELETE);
    }

    @Override
    public Result updateLabel(Long id, Label label) {
        label.setId(id);
        adminLabelMapper.updateById(label);
        return Result.ok(Message.UPDATE);
    }

    @Override
    public Result findLabelById(Long id) {
        return Result.ok(Message.SELECT, adminLabelMapper.selectById(id));
    }

    @Override
    public Result findAllLabel() {
        return Result.ok(Message.SELECT, adminLabelMapper.selectList(null));
    }
}
