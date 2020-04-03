package com.ithub.source.learn.base;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.*;

/**
 * 测试2
 */
public class TestTwo {
    @Test
    public void test01(){

        System.out.println(1&2);

    }

    @Test
    public void test02(){
        int count = 5;

        count--;

        System.out.println(count);
    }

    @Test
    public void test03(){
        List<String> remainEle = Arrays.asList("a", "b", "c", "d", "e");
        List<String> tempRemain = new ArrayList<>(remainEle);
        List<String> collection = new ArrayList<>(new ArrayList<>());
        collection.add(tempRemain.remove(0));
        System.out.println(collection);
    }

    @Test
    public void test04(){
        double pow = Math.pow(2, 5);
        System.out.println(pow);
    }

    @Test
    public void test05(){
        TreeSet<String> set = new TreeSet<>();
        set.add("SETTLE_TYPE");
        set.add("FEE_TYPE");
        set.add("SERVER_CODE");

        set.comparator();
        System.out.println(set);

        String str = StringUtils.join(Arrays.asList(set.toArray()), "_");
        System.out.println(str);

    }

    @Test
    public void test06(){


        if(1==1 && 1==2){
            System.out.println("1");
        }else if(1==1 && 1==3){
            System.out.println(2);
        }
    }

}
