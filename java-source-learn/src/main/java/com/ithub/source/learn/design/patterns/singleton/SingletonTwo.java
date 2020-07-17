package com.ithub.source.learn.design.patterns.singleton;

/**
 * 懒汉式 线程安全
 */
public class SingletonTwo {

    private static SingletonTwo singleton;
    private SingletonTwo(){
    }

    public static synchronized SingletonTwo getInstance(){
        if(singleton==null){
            singleton = new SingletonTwo();
        }
        return singleton;
    }
}
