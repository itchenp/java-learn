/**
 * Copyright (C), 开店宝支付服务有限公司
 * FileName: Drools5xTest
 * Author:   CP.
 * Time:     2019-12-12 16:44
 * Description:
 */
package com.ithub.source.learn;

import com.ithub.source.learn.model.Product;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import java.util.Collection;

/**
 *
 *
 * @author CP.
 * @create 2019/12/12
 * @since 1.0.0
 */
public class Drools5xTest {

    public static void main(String[] args) {
        Drools5xTest drools5xTest = new Drools5xTest();
        drools5xTest.oldExecuteDrools();
    }


    private void oldExecuteDrools(){
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("rules/Rules.drl",this.getClass()), ResourceType.DRL);

        if(kbuilder.hasErrors()){
            System.out.println(kbuilder.getErrors().toString());
        }

        Collection<KnowledgePackage> pkgs = kbuilder.getKnowledgePackages();
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(pkgs);

        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        Product product = new Product();
        product.setType(Product.GOLD);
        ksession.insert(product);
        ksession.fireAllRules();
        ksession.dispose();
        System.out.println("The discount for the product " + product.getType()
                + " is " + product.getDiscount()+"%");

    }
}