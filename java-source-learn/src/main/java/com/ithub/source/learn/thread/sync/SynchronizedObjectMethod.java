package com.ithub.source.learn.thread.sync;

/**
 * 对象锁：synchronized加在方法上
 */
public class SynchronizedObjectMethod implements Runnable{

    static SynchronizedObjectMethod instance = new SynchronizedObjectMethod();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }

    @Override
    public void run() {
        method();
    }

    private synchronized void method(){
        System.out.println("我是对象锁的方法形式。我叫：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

}
