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
public class DingtouTask extends AbstractTask<DingtouInfo> {

    @Resource
    private DingTouService dingTouService;

    @Override
    public List loadData() {
        return dingTouService.loadData();
    }

    @Override
    public List filterData(List<DingtouInfo> list) {
        return list.stream().filter(info -> dingTouService.isTimeUp(info)).collect(Collectors.toList());
    }

    @Override
    public void processData(List<DingtouInfo> list) {
        list.forEach(dingTouService::dingtou);

    }

    @Override
    @Scheduled(fixedDelay = 1000 * 10)
    public void start() {
        doTask();
    }
}
