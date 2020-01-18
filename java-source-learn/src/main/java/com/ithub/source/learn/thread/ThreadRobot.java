package com.ithub.source.learn.thread;

import java.util.List;

public interface ThreadRobot<T, K> {
    /**
     * 工作函数
     * @param queue
     * @param param
     */
    void excute(List<T> queue, K param);
}
