package com.ithub.source.learn.base;

import org.junit.Test;

import java.math.BigDecimal;

public class TestThree {

    @Test
    public void test01(){
        BigDecimal bigDecimalfee = new BigDecimal("-0.1");
        if (bigDecimalfee.signum() == -1) {
            System.out.println("111");
        }
    }
}
