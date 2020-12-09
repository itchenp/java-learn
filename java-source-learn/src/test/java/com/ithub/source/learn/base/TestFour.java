package com.ithub.source.learn.base;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestFour {

    @Test
    public void test01(){
        // 正则匹配
        String str ="200000000.00";
        String patten = "^([1-9]\\d{0,12}|0)([.]?|(\\.\\d{1,2})?)$";

        Pattern p=Pattern.compile(patten);
        Matcher m=p.matcher(str);
        System.out.println(m.matches());
    }

    @Test
    public void test02(){
        BigDecimal one = new BigDecimal(-0.02);
        BigDecimal two = new BigDecimal(0);
        System.out.println(one.compareTo(two));
    }

    @Test
    public void test03(){
        List<String> list = Arrays.asList("a","ab","abc","abcd");
    }

    @Test
    public void test04(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                list.remove(integer);
        }
    }

    @Test
    public void test05(){
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test06(){
        long i = 10L;
        double j = 4.5D;

        System.out.println(i-j);

        double random = ThreadLocalRandom.current().nextDouble(0, 3);

        System.out.println(i-random);
    }

    @Test
    public void test07(){
        if(true || true){
            System.out.println("1");
        }
        if(false || true){
            System.out.println("2");
        }
        if(false || false){
            System.out.println("3");
        }
        if(true || false){
            System.out.println("4");
        }


    }
}
