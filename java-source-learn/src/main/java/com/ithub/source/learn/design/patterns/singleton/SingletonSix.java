package com.ithub.source.learn.design.patterns.singleton;

/**
 * 双重校验
 */
public class SingletonSix {

    private static SingletonSix singleton;
    private SingletonSix(){
    }

    public static SingletonSix getInstance(){
        if(singleton == null){
            synchronized (SingletonSix.class){
                if(singleton == null){
                    singleton = new SingletonSix();
                }
            }
        }
        return singleton;
    }
}
