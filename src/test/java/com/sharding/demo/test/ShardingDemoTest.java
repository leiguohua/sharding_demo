package com.sharding.demo.test;

import com.sharding.demo.model.Order;
import com.sharding.demo.server.impl.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: lgh
 * @Date: 2021/3/25 15:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShardingDemoTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void addOrder(){
        for(int i = 0; i < 20; i++){
            Order order = new Order();
            //随机0，1
            order.setUserId(ThreadLocalRandom.current().nextInt(2));
            order.setCreateTime(LocalDateTime.now());
            order.setOrderNo(String.valueOf(System.currentTimeMillis()).replace("-", ""));
            orderService.add(order);
        }
    }
}
