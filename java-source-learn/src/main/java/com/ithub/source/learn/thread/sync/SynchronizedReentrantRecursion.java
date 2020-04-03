package com.ithub.source.learn.thread.sync;

/**
 * 可重入粒度：递归
 */
public class SynchronizedReentrantRecursion {

    int flag = 0;

    public static void main(String[] args) {
        SynchronizedReentrantRecursion instance = new SynchronizedReentrantRecursion();
        instance.method();
    }

    private synchronized void method() {
        System.out.println("flag:"+flag);
        if(flag==0){
            flag++;
            method();
        }
    }
}
