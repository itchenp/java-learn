package com.ithub.source.learn.design.patterns.singleton;

/**
 * 饿汉式
 */
public class SingletonThree {

    private static SingletonThree singleton = new SingletonThree();
    private SingletonThree(){
    }

    public static SingletonThree getInstance(){
        return singleton;
    }
}
