package com.ithub.source.learn.thread;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程任务工厂
 */
public class ThreadTaskFactory {
    /**
     * 创建批量任务线程池
     * @param roboot
     * 			工作机器人
     * @param maxThread
     * 			线程数
     * @param quqe
     * 			消费队列
     * @param param
     * 			机器人用到的参数
     * @return
     */
    public static<T, K> ThreadTask<T> createBatch(ThreadRobot<T, K> roboot, int maxThread, List<T> quqe, K param) throws NullTaskException {
        return new BatchThreadTask<T, K>(roboot, maxThread, quqe, new ReentrantLock(), param);
    }
}
