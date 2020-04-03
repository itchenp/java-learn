package com.ithub.source.learn.thread.sync;

/**
 * 反编译字节码
 * 1:javac 编译成class文件
 * 2:javap -rerbose class文件成字节码
 */
public class Decomplication {

    private Object lock = new Object();

    public void method(Thread thread){
        synchronized (lock){

        }
    }
}
