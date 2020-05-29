package com.ithub.source.learn.lambda;

import java.util.function.UnaryOperator;

public class UnaryOperatorLearn {

    public static void main(String[] args) {

        UnaryOperator<Integer> ip1 = (i)->i*i;
        System.out.println(ip1.apply(10));

        UnaryOperator<String> ip2 = (i)->input(i);
        System.out.println(ip2.apply("a"));

    }

    public static String input(String i){
        return "i:"+i;
    }

//    private String input(String str){
//        return str;
//    }
}
