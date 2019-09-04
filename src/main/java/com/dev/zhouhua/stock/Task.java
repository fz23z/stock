package com.dev.zhouhua.stock;

/**
 * 任务接口
 * @param <T>
 */
public interface Task<T> {



     /**
      * 运行任务
      * @return
      */
     void start();
}
