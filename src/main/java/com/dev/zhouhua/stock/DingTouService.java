package com.dev.zhouhua.stock;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DingTouService {

    /**
     * 从db捞取定投信息
     *
     * @return
     */
    public List<DingtouPlan> loadData() {

        // todo 从db捞取状态为生效的定投数据

        // ******** mock ******/
        Stock stock1 = Stock.builder().id("1").name("海康").no("000001").price(new BigDecimal(35)).build();

        DingtouRule rule1 =
            DingtouRule.builder().money(new BigDecimal(100)).period(DingtouPeriod.WEEK).dayOfPeriod(3).build();

        List<DingtouPlan> infoList =
            Lists.newArrayList(DingtouPlan.builder().rule(rule1).stock(stock1).userId("123").build());
        // ******** mock ******/

        return infoList;

    }

    public Result dingtou(DingtouPlan info) {
        // todo 执行定投逻辑 db中生成定投流水记录

        info.setLastDoneTime(Calendar.getInstance().getTime());

        log.info("user {} buy {} {}", info.getUserId(), info.getStock().getName(), info.getRule().getMoney());
        return Result.success();
    }

}
