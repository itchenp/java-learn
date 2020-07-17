package com.ithub.source.learn.design.patterns.observer;

public class LaoLi implements Person{
    private String name = "小李";

    public LaoLi() {

    }

    @Override
    public void getMessage(String message) {
        System.out.println(name + " 接到小美的消息: " + message);
    }
}
