package com.dev.zhouhua.stock;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class DingtouTask extends AbstractDataProcessTask<DingtouPlan> {

    @Resource
    private DingTouService dingTouService;

    @Override
    public List loadData() {
        return dingTouService.loadData();
    }

    @Override
    public List filterData(List<DingtouPlan> list) {
        return list.stream().filter(info -> info.isTodo()).collect(Collectors.toList());
    }

    @Override
    public void processData(List<DingtouPlan> list) {
        list.forEach(dingTouService::dingtou);

    }

    @Override
    @Scheduled(cron = "0 30 9 ? * * ")
    public void start() {
        // todo 真实项目中分布式环境下，由中心节点向集群发布定时任务，数据量大且对处理效率要求高的话可以对数据进行分片后再处理
        // todo 若分片后单机任务数还比较多可以单机启线程池并行处理
        doTask();
    }
}
