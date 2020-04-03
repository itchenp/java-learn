package com.ithub.source.learn.thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedToLock {

    public synchronized void method1(){
        System.out.println("synchronized形式的方法");
    }

    Lock lock = new ReentrantLock();
    public void method2(){
        lock.lock();
        try {
            System.out.println("lock形式的锁");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedToLock instance = new SynchronizedToLock();
        instance.method1();
        instance.method2();
    }
}
