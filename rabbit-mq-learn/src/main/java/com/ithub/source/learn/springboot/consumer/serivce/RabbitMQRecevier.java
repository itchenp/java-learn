/**
 * Copyright (C), 开店宝支付服务有限公司
 * FileName: RabbitMQRecevier
 * Author:   CP.
 * Time:     2019-12-24 17:07
 * Description:
 */
package com.ithub.source.learn.springboot.consumer.serivce;

import com.ithub.source.learn.springboot.consumer.entity.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 *
 *
 * @author CP.
 * @create 2019/12/24
 * @since 1.0.0
 */
@Component
public class RabbitMQRecevier {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-1",durable = "true"),
            exchange = @Exchange(value = "exchange-1",durable = "true",type = "topic",ignoreDeclarationExceptions = "true"),
            key = "springboot.#"
    ))
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws IOException {
        System.out.println("============================");
        System.out.println("message: "+message.getPayload());
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);

        channel.basicAck(deliveryTag,false);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${spring.rabbitmq.listener.order.queue.name}",
                    durable="${spring.rabbitmq.listener.order.queue.durable}"),
            exchange = @Exchange(value = "${spring.rabbitmq.listener.order.exchange.name}",
                    durable="${spring.rabbitmq.listener.order.exchange.durable}",
                    type= "${spring.rabbitmq.listener.order.exchange.type}",
                    ignoreDeclarationExceptions = "${spring.rabbitmq.listener.order.exchange.ignoreDeclarationExceptions}"),
            key = "${spring.rabbitmq.listener.order.key}"
    )
    )
    @RabbitHandler
    public void onOrderMessage(@Payload Order order,
                               Channel channel,
                               @Headers Map<String, Object> headers) throws Exception {
        System.out.println("--------------------------------------");
        System.out.println("消费端order: " + order.getId());
        Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        //手工ACK
        channel.basicAck(deliveryTag, false);
    }

}