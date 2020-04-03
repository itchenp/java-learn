package com.ithub.source.learn.thread;

import lombok.extern.slf4j.Slf4j;

public class DeadLock {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new Dead(lockA,lockB)).start();
        new Thread(new Dead(lockB,lockA)).start();
    }

}

@Slf4j
class Dead implements Runnable {

    private String lockA;
    private String lockB;

    public Dead(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized(lockA){
           log.debug("lockA get lockB {}",lockB);
           synchronized (lockB){
               log.debug("lockB get lockA {}",lockA);
           }
        }
    }
}


