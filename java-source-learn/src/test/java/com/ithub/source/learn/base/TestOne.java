package com.ithub.source.learn.base;

import org.junit.Test;

/**
 * 测试1
 */
public class TestOne {
    @Test
    public void test01(){
        String str = " ";
        System.out.println(str.length());
        System.out.println(str.isEmpty());
    }

    @Test
    public void test02(){
        String value = "Aesfe2";
        System.out.println(value.charAt(3));
    }

    @Test
    public void test03(){
        System.out.println(2 << 12);
        System.out.println(2 >> 4);
    }

    @Test
    public void test04(){
        int i = 1;
        do{
            i++;
        }while (i<10);

        System.out.println(i);
    }
}
