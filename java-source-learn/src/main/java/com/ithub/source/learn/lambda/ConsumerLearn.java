package com.ithub.source.learn.lambda;

import java.util.function.Consumer;

public class ConsumerLearn {

    public static void main(String[] args) {

        Consumer<Integer> ip1 = (in)->{inPut(in);};
        ip1.accept(123);

        Consumer<Integer> ip2 = ConsumerLearn::inPut;
        ip2.accept(456);

        Consumer<String> ip3 = new ConsumerLearn()::inPutP;
        ip3.accept("789");
    }

    public static void inPut(Integer in){
        System.out.println("in : " + in);
    }

    private void inPutP(String str){
        System.out.println("in : " +str);
    }
}
