package com.ithub.source.learn.thread.sync;

/**
 * 对象锁 this 或者创建一个自己的对象lock
 */
public class SynchronizedObjectCodeBlock implements Runnable{

    static SynchronizedObjectCodeBlock instance = new SynchronizedObjectCodeBlock();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }

//    Object lock1 = new Object();
//    Object lock2 = new Object();
//    @Override
//    public void run() {
//
//        synchronized (lock1) {
//            System.out.println("我是lock1。我叫：" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "运行结束");
//        }
//        synchronized (lock2) {
//            System.out.println("我是lock2。我叫：" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "运行结束");
//        }
//    }


    @Override
    public void run() {

        synchronized (this) {
            System.out.println("我是对象锁。我叫：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }

    }
}
