package com.ithub.source.learn.lambda;

import java.util.function.BiFunction;

public class BiFunctionLearn {

    public static void main(String[] args) {

        BiFunction<String,Integer,String> ip1 = (a,b)->input(a,b);
        System.out.println(ip1.apply("a",1));

        BiFunction<String,Integer,String> ip2 = BiFunctionLearn::input;
        System.out.println(ip2.apply("b",2));
    }

    public static String input(String a,Integer b){
        return a+"=="+b;
    }
}
