package com.ithub.source.learn.design.patterns.singleton;

/**
 * 静态内部类
 */
public class SingletonFour {

    private static class SingletonHolder{
        private static final SingletonFour INSTANCE = new SingletonFour();
    }

    private SingletonFour(){
    }

    public static SingletonFour getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
