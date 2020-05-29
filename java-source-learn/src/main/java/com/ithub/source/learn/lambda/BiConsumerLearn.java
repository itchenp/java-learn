package com.ithub.source.learn.lambda;

import java.util.function.BiConsumer;

public class BiConsumerLearn {

    public static void main(String[] args) {

        BiConsumer<String,Long> ip1 = (str,l)->{input(str,l);};
        ip1.accept("abc",123L);

        BiConsumer<String,Long> ip2 = BiConsumerLearn::input;
        ip2.accept("efg",456L);

        BiConsumer<String,Integer> ip3 = new BiConsumerLearn()::inputP;
        ip3.accept("efg",789);
    }

    public static void input(String str,Long l){
        System.out.println("str : "+str+" l : "+l);
    }

    private void inputP(String str,Integer i){
        System.out.println("str : "+str+" i : "+i);
    }

}
