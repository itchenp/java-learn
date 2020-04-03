package com.ithub.source.learn.thread.sync;

/**
 * 可重入颗粒：调用父类方法
 */
public class SynchronizedReentrantSuperClass {

    public synchronized void doSomething(){
        System.out.println("父类方法");
    }
}

class SynchronizedReentrantClass extends SynchronizedReentrantSuperClass {

    public synchronized void doSomething(){
        System.out.println("子类方法");
        super.doSomething();
    }

    public static void main(String[] args) {
        SynchronizedReentrantClass instance = new SynchronizedReentrantClass();
        instance.doSomething();
    }

}
