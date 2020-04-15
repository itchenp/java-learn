package com.ithub.source.learn.base;

import org.junit.Test;

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
}
