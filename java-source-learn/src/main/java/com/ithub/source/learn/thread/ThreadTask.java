package com.ithub.source.learn.thread;

public interface ThreadTask<T> {

    /**
     * 开始线程
     */
    void start();

    /**
     * 结束线程
     */
    void stop();

    /**
     * 获得任务数
     * @return
     */
    int getTaskCount();

    /**
     * 获得线程数
     * @return
     */
    int getThreadCount();

    /**
     * 等待完成
     * @return
     * 		等待时间
     */
    long doWait() throws NotStartedException;

}
