package com.ithub.source.learn.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;

public class BatchThreadTask<T, K> implements ThreadTask<T> {
    /**
     * 消费内容
     */
    private LinkedList<T> param = new LinkedList<>();

    /**
     * 最大线程数
     */
    private int maxThread = 3;

    /**
     * 当前线程数
     */
    private int thisThread = 0;

    /**
     * 执行机器人
     */
    private ThreadRobot<T, K> roboot;

    private long startTime = 0;
    private K member = null;

    private Lock lock = null;

    private boolean over = false;



    /**
     * 创建批量任务
     * @param roboot
     * 			任务执行机器人
     * @param maxThread
     * 			最大机器人数量
     * @param param
     * 			消费内容
     */
    public BatchThreadTask(ThreadRobot<T, K> roboot, int maxThread, List<T> param, Lock lock, K member) throws NullTaskException {
        if(null == param || param.isEmpty()) {
            throw new NullTaskException();
        }
        if(maxThread > 0) {
            this.maxThread = maxThread;
        }
        for (T t : param) {
            this.param.addLast(t);
        }
        this.roboot = roboot;
        this.lock = lock;
        this.member = member;
    }

    @Override
    public void start() {
        final int average = param.size() / maxThread;
        final int surplus = param.size() % maxThread;
        startTime = System.currentTimeMillis();
        for(int i = 1; i <= maxThread; i++) {
            final int co = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    List<T> p = new ArrayList<>();
                    try {
                        for(int j = ((co - 1) * average); j < co * average; j ++) {
                            p.add(getList());
                        }
                        if(co == maxThread) {
                            for(int j = 0; j < surplus; j++) {
                                try {
                                    T item = getList();
                                    if(null != item) {
                                        p.add(item);
                                    }
                                }catch (NoSuchElementException e) {
                                    e.fillInStackTrace();
                                }
                            }
                        }
                        roboot.excute(p, member);
                    }finally {
                        synchronized (lock) {
                            thisThread --;
                            if(thisThread == 0) {
                                over = true;
                            }
                        }
                    }
                }
            });
            t.start();
            thisThread ++;
        }
    }


    @Override
    public void stop() {
        //不实现
    }

    @Override
    public int getTaskCount() {
        return param.size();
    }

    @Override
    public int getThreadCount() {
        // TODO Auto-generated method stub
        return thisThread;
    }

    @Override
    public long doWait() throws NotStartedException {
        while(!over) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            continue;
        }

        if(startTime == 0) {
            throw new NotStartedException();
        }
        return System.currentTimeMillis() - startTime;
    }

    private T getList() {
        synchronized (lock) {
            return param.removeFirst();
        }
    }
}
