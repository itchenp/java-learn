package com.ithub.source.learn.thread.sync;

/**
 * 可重入颗粒：调用另外的方法
 */
public class SynchronizedReentrantOtherMethod {

    public static void main(String[] args) {
        SynchronizedReentrantOtherMethod instance = new SynchronizedReentrantOtherMethod();
        instance.method1();
    }

    private synchronized void method1() {
        System.out.println("method1");
        method2();
    }

    private synchronized void method2() {
        System.out.println("method2");
    }


}
