/**
 * Copyright (C), 开店宝支付服务有限公司
 * FileName: EnumKeyGetter
 * Author:   CP.
 * Time:     2019-12-25 15:49
 * Description:
 */
package com.ithub.source.learn.enumerate;

/**
 *
 *
 * @author CP.
 * @create 2019/12/25
 * @since 1.0.0
 */
public interface EnumKeyGetter<T extends Enum<T>, K> {
    K getKey(T enumValue);
}