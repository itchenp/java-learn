/**
 * Copyright (C), 开店宝支付服务有限公司
 * FileName: RabbitMQApplicationTests
 * Author:   CP.
 * Time:     2019-12-24 14:06
 * Description:
 */
package com.ithub.source.learn.springboot.test;

import com.ithub.source.learn.springboot.entity.Order;
import com.ithub.source.learn.springboot.SpringBootRabbitMQProcuderApplication;
import com.ithub.source.learn.springboot.service.RabbitMQSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author CP.
 * @create 2019/12/24
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRabbitMQProcuderApplication.class)
public class SpringBootRabbitMQProcuderApplicationTests {

    @Autowired
    RabbitMQSender rabbitMQSender;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Test
    public void testSend1() throws Exception {
        for (int i = 0; i < 10; i++) {
            Map<String,Object> properties = new HashMap<>();
            properties.put("number","12345"+i);
            properties.put("send_time",simpleDateFormat.format(new Date()));

            rabbitMQSender.send("Hello RabbitMQ For Spring boot",properties);
        }


    }

    @Test
    public void testSender2() throws Exception {
        Order order = new Order("001", "第一个订单");
        rabbitMQSender.sendOrder(order);
    }

}