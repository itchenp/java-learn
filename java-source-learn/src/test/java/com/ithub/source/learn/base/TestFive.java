package com.ithub.source.learn.base;

import org.junit.Test;

import java.util.Random;

/**
 * @author CP.
 * @date 2022-02-15 16:14
 */
public class TestFive {

    @Test
    public void test01(){
        for (int i = 1; i < 11; i++) {
            Random random = new Random(10);
            int ii = random.nextInt(i*10+i);
            System.out.println(ii);
        }

    }

    @Test
    public void test02(){
        String a = "abc";
        String b = new String("abc");
        String c = b.intern();

        System.out.println(a==b);
        System.out.println(b==c);
        System.out.println(a==c);
    }
}
