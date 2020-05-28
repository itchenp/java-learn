package com.ithub.source.learn.lambda;

import java.util.function.Function;

public class FunctionLearn {

    public static void main(String[] args) {
        Function<Integer,String> ip1 = (i)->input(i);
        System.out.println(ip1.apply(12));

        Function<Integer,String> ip2 = FunctionLearn::input;
        System.out.println(ip2.apply(34));

        Function<String,String> ip3 = new FunctionLearn()::input;
        System.out.println(ip3.apply("abc"));
    }

    public static String input(Integer i){
        return "i:"+i;
    }

    private String input(String str){
        return str;
    }
}
