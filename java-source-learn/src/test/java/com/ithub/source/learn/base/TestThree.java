package com.ithub.source.learn.base;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class TestThree {

    @Test
    public void test01(){
        BigDecimal bigDecimalfee = new BigDecimal("-0.1");
        if (bigDecimalfee.signum() == -1) {
            System.out.println("111");
        }
    }

    @Test
    public void test02(){
        String strs = "BB|AA";
        System.out.println(strs.contains("|"));
        String[] split = strs.split("\\|");
        for (String s : split) {
            System.out.println(s);
        }
        System.out.println(Arrays.toString(strs.split("\\|")));
    }

    @Test
    public void test03(){
        Set<String> set = new HashSet<>();
        set.add("AA");
        set.add("BB");
        set.add("CC");

        String[] strings = set.toArray(new String[0]);
        System.out.println(Arrays.toString(strings));

    }

    @Test
    public void test04(){
        String[] s1 = new String[]{"A","B","C","D","E","F"};
        String[] s2 = new String[]{"B","D","F"};

        List<String> list = new ArrayList<String>(){{addAll(Arrays.asList(s1));}};
        System.out.println(list);
        list.remove("B");

        System.out.println(list);
//        System.out.println(Arrays.asList(s1).set(s1.length-1,"G"));

//        System.out.println(Arrays.toString(s1));
    }

    @Test
    public void test05(){
        System.out.println(Double.parseDouble("5.2"));
    }

    @Test
    public void test06(){
        System.out.println(12&7);
        System.out.println(12%8);
        System.out.println(Integer.toHexString(0x01<<18));
    }
}
