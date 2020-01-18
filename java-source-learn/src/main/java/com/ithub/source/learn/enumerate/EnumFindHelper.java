/**
 * Copyright (C), 开店宝支付服务有限公司
 * FileName: EnumFindHelper
 * Author:   CP.
 * Time:     2019-12-25 15:49
 * Description:
 */
package com.ithub.source.learn.enumerate;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用 GOF的桥接模式
 *
 * 枚举的反向查找其实只需关注两件事情，
 * a 提供枚举值描述到枚举值的映射
 * b 能从枚举值描述查找到枚举值，查找不到能提供默认值
 *
 * @author CP.
 * @create 2019/12/25
 * @since 1.0.0
 */
public class EnumFindHelper<T extends Enum<T>, K> {

    protected Map<K, T> map = new HashMap<K, T>();

    public EnumFindHelper(Class<T> clazz, EnumKeyGetter<T, K> keyGetter) {
        try {
            for (T enumValue : EnumSet.allOf(clazz)) {
                map.put(keyGetter.getKey(enumValue), enumValue);
            }
        } catch (Exception e) {
            //eror handler
        }
    }

    public T find(K key, T defautValue) {
        T value = map.get(key);
        if (value == null) {
            value = defautValue;
        }
        return value;
    }
}