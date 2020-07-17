package com.ithub.source.learn.design.patterns.observer;

public class LaoWang implements Person{
    private String name = "小王";

    public LaoWang() {
    }

    @Override
    public void getMessage(String message) {
        System.out.println(name + " 接到小美的消息: " + message);
    }
}
