package com.ithub.source.learn.lambda;

import java.util.function.Supplier;

public class SupplierLearn {

    public static void main(String[] args) {

        Supplier<String> op1 = SupplierLearn::outPut;
        System.out.println(op1.get());

        Supplier<String> op2 = ()->outPut();
        System.out.println(op2.get());

        Supplier<String> op3 = new SupplierLearn()::outPutPri;
        System.out.println(op3.get());


    }

    public static String outPut(){
        return "11223344";
    }

    private String outPutPri(){
        return "aabbccdd";
    }
}
