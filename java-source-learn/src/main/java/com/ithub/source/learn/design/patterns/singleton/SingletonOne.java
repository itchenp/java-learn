package com.ithub.source.learn.design.patterns.singleton;

/**
 * 懒汉式 线程不安全
 */
public class SingletonOne {

    private static SingletonOne singleton;
    private SingletonOne(){
    }

    public static SingletonOne getInstance(){
        if(singleton==null){
            singleton = new SingletonOne();
        }
        return singleton;
    }
}
