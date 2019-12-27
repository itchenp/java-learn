/**
 * Copyright (C), 开店宝支付服务有限公司
 * FileName: Product
 * Author:   CP.
 * Time:     2019-12-12 16:29
 * Description:
 */
package com.ithub.source.learn.model;

import lombok.Data;

/**
 *
 *
 * @author CP.
 * @create 2019/12/12
 * @since 1.0.0
 */
@Data
public class Product {

    public static final String DIAMOND = "DIAMOND";
    public static final String GOLD = "GOLD";

    private String type;
    private int discount;


}