package com.ithub.source.learn.lambda;

import java.util.function.BinaryOperator;

public class BinaryOperatorLearn {
    public static void main(String[] args) {

        BinaryOperator<String> ip1 = (a,b)->input(a,b);
        System.out.println(ip1.apply("a", "b"));
    }

    public static String input(String a,String b){
        return a+"+++"+b;
    }
}
