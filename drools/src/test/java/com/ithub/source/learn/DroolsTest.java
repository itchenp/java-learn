/**
 * Copyright (C), 开店宝支付服务有限公司
 * FileName: DroolsTest
 * Author:   CP.
 * Time:     2019-12-12 17:15
 * Description:
 */
package com.ithub.source.learn;

import com.ithub.source.learn.model.Product;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 *
 *
 * @author CP.
 * @create 2019/12/12
 * @since 1.0.0
 */
public class DroolsTest {

    @Test
    public void testRules(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();

        KieSession kSession = kieContainer.newKieSession("ksession-rule");

        Product product = new Product();
        product.setType(Product.GOLD);
        kSession.insert(product);
        int count = kSession.fireAllRules();
        System.out.println("命中了" + count + "条规则！");
        System.out.println(" 商 品 " +product.getType() + " 的 商 品 折 扣 为 " +
                product.getDiscount() + "%。 ");
    }
}