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

    @Test
    public void test05(){
//        for (int i = 1; i < 7482;) {
//            // =PHONETIC(C1:D100)
//            System.out.println("=PHONETIC(C"+(i)+":D"+(i+99)+")");
//            i = i +100;
//        }

        for (int i = 1; i < 75; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void test06(){
        String name = "${AB}";
        System.out.println(
                name.length()
        );
    }
    
}
