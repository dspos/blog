package com.yetao.blog;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BlogApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(IdWorker.get32UUID());
        System.out.println(IdWorker.getId());
        System.out.println(IdWorker.getId());
        System.out.println(IdWorker.getIdStr());
        System.out.println(IdWorker.getMillisecond());
        System.out.println(IdWorker.getTimeId());
        System.out.println(IdWorker.getTimeId());
    }

}
