package com.ithub.source.learn.lang;


import org.junit.Test;

public class StringStudy {


    @Test
    public void split01(){

        String value = ",12,34,45,67,";
        String[] splitStrs = value.split(",");
        System.out.println(splitStrs.length);

        // jdk 1.7  length 5
        // jdk 1.8  length 4
    }

}
