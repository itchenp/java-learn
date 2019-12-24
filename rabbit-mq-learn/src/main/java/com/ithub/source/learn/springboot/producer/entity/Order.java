/**
 * Copyright (C), 开店宝支付服务有限公司
 * FileName: Order
 * Author:   CP.
 * Time:     2019-12-24 15:45
 * Description:
 */
package com.ithub.source.learn.springboot.producer.entity;

import java.io.Serializable;

/**
 *
 *
 * @author CP.
 * @create 2019/12/24
 * @since 1.0.0
 */
public class Order implements Serializable {

    private String id;
    private String name;

    public Order() {
    }
    public Order(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}