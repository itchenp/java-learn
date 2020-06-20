package com.ithub.source.learn.base;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestFour {

    @Test
    public void test01(){
        // 正则匹配
        String str ="";
        String patten = "^(1)|(2)|(3)|(4)|(5)|(6)|$";

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

    public void test04(){

    }
}
