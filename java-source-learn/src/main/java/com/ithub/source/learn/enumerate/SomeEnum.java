/**
 * Copyright (C), 开店宝支付服务有限公司
 * FileName: SomeEnum
 * Author:   CP.
 * Time:     2019-12-25 15:50
 * Description: 枚举样例
 */
package com.ithub.source.learn.enumerate;

/**
 * 枚举样例
 *
 * @author CP.
 * @create 2019/12/25
 * @since 1.0.0
 */
public enum SomeEnum {
    A("ADes", 1),
    B("BDes", 2),
    unknown("UNKNWONDes", 3);

    private String des;
    private int order;

    private SomeEnum(String des, int order){
        this.des = des;
        this.order = order;
    }

    static final EnumFindHelper<SomeEnum, String> desptHelper = new EnumFindHelper<SomeEnum, String>(
            SomeEnum.class, new DesptGetter());

    static final EnumFindHelper<SomeEnum, Integer> orderHelper = new EnumFindHelper<SomeEnum, Integer>(
            SomeEnum.class, new OrderKeyGetter());

    static class DesptGetter implements EnumKeyGetter<SomeEnum, String> {
        @Override
        public String getKey(SomeEnum enumValue) {
            return enumValue.des;
        }
    }

    static class OrderKeyGetter implements EnumKeyGetter<SomeEnum, Integer> {

        @Override
        public Integer getKey(SomeEnum enumValue) {
            return enumValue.order;
        }
    }

    public static SomeEnum find(String despt, SomeEnum defaultValue){
        return desptHelper.find(despt, defaultValue);
    }

    public static SomeEnum find(int order, SomeEnum defaultValue){
        return orderHelper.find(order, defaultValue);
    }
}
