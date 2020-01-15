package com.ithub.source.learn.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @Auther: chenpeng
 * @Date: 2020/1/13 15:14
 * @Description:
 */
public class BeanFactoryTest {

    public void test01(){
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
    }
}
