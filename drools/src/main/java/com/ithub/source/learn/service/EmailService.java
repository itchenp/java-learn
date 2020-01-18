/**
 * Copyright (C), 开店宝支付服务有限公司
 * FileName: EmailService
 * Author:   CP.
 * Time:     2019-12-30 16:32
 * Description:
 */
package com.ithub.source.learn.service;

import com.ithub.source.learn.model.Message;

/**
 *
 *
 * @author CP.
 * @create 2019/12/30
 * @since 1.0.0
 */
public class EmailService {

    public static void sendEmail(Message message){
        System.out.println("Send message to email,the fired rule is '" + message.getRule()
                + "', and description is '" +
                message.getDesc() + "'");
    }

}