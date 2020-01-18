/**
 * Copyright (C), 开店宝支付服务有限公司
 * FileName: RabbitMQApplication
 * Author:   CP.
 * Time:     2019-12-20 16:02
 * Description:
 */
package com.ithub.source.learn.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 *
 * @author CP.
 * @create 2019/12/20
 * @since 1.0.0
 */
@SpringBootApplication
public class SpringBootRabbitMQProcuderApplication {

    public static void main(String[] args) throws Exception {
//        Properties properties = new Properties();
//        InputStream in =
//                SpringBootRabbitMQProcuderApplication.class.getClassLoader().getResourceAsStream("application" +
//                        "-producer.properties");
//
//        properties.load(in);
//
//        SpringApplication springApplication = new SpringApplication(SpringBootRabbitMQProcuderApplication.class);
//        springApplication.setDefaultProperties(properties);
//        springApplication.run(args);
        SpringApplication.run(SpringBootRabbitMQProcuderApplication.class);
    }
}