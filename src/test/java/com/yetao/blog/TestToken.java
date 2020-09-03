package com.yetao.blog;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/11 22:17
 */

public class TestToken {
    public static void main(String[] args) {
        System.out.println(IdWorker.get32UUID());
        System.out.println(IdWorker.getId());
        System.out.println(IdWorker.getId());
    }
}
