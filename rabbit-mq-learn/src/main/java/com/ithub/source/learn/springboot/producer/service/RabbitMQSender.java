/**
 * Copyright (C), 开店宝支付服务有限公司
 * FileName: RabbitMQSender
 * Author:   CP.
 * Time:     2019-12-24 13:53
 * Description:
 */
package com.ithub.source.learn.springboot.producer.service;

import com.ithub.source.learn.springboot.producer.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

/**
 * @author CP.
 * @create 2019/12/24
 * @since 1.0.0
 */
@Component
public class RabbitMQSender {

    @Autowired
    RabbitTemplate rabbitTemplate;

    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.out.println("correlationData: " + correlationData);
            System.out.println("ack: " + ack);
            if (!ack) {
                System.out.println("异常处理...");
            }
        }
    };

    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(org.springframework.amqp.core.Message message, int replyCode, String replyText,
                                    String exchange, String routingKey) {
            System.out.println("return exchange: " + exchange + " routingKey: " + routingKey + " " +
                    "replyCode: " + replyCode + " replyText : " + replyText);
        }
    };

    public void send(Object message, Map<String, Object> properties) throws Exception {
        MessageHeaders mhs = new MessageHeaders(properties);
        Message msg = MessageBuilder.createMessage(message, mhs);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        CorrelationData cd = new CorrelationData();
        cd.setId(UUID.randomUUID().toString().replace("-",""));
        rabbitTemplate.convertAndSend("exchange-1", "springboot.hello", msg,cd);
    }

    public void sendOrder(Order order) throws Exception {
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        CorrelationData cd = new CorrelationData();
        cd.setId(UUID.randomUUID().toString().replace("-",""));
        rabbitTemplate.convertAndSend("exchange-2", "springboot.hello", order,cd);
    }

}