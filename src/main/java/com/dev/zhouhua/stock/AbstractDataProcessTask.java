package com.dev.zhouhua.stock;

import java.util.List;

/**
 * @author jiangyanyan
 * @since 2019/7/28 下午1:36
 */
public abstract class AbstractDataProcessTask<T> implements Task {

    public void doTask() {
        List list = loadData();
        list = filterData(list);
        processData(list);
    }

    public abstract List<T> loadData();

    public abstract List<T> filterData(List<T> list);

    public abstract void processData(List<T> list);

}
