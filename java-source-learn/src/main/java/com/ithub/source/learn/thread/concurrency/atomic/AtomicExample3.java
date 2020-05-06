package com.ithub.source.learn.thread.concurrency.atomic;

import com.ithub.source.learn.thread.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.LongAdder;

@Slf4j
@ThreadSafe
public class AtomicExample3 {

    public static int clientTotal = 5000;
    public static int threadTotal = 200;
    public static LongAdder count = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                }catch (Exception e){
                    log.error("exception {}",e);
                }finally {
                    semaphore.release();
                }
                countDownLatch.countDown();
            });
        } 
        countDownLatch.await();
        executorService.shutdown();
        log.info("count {}",count);
    }

    private static void add(){
        count.increment();
    }
}
