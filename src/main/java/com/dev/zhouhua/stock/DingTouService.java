package com.dev.zhouhua.stock;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
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
    public List<DingtouInfo> loadData() {

        //******** mock ******/
        Date date = null;
        try {
            date = DateUtils.parseDate("2019-07-27 00:00:00", "yyyy-MM-dd hh:mm:ss");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Stock stock1 = Stock.builder().id("1").name("海康").no("000001").price(new BigDecimal(35)).build();

        DingtouRule rule1 =
            DingtouRule.builder().money(new BigDecimal(100)).period(DingtouPeriod.DAY).startTime(date).build();

        List<DingtouInfo> infoList =
            Lists.newArrayList(DingtouInfo.builder().rule(rule1).stock(stock1).userId("123").doneTime(0).nextTime(date).build());
        //******** mock ******/

        //todo 从db捞数据，捞取逻辑：判断nextTime距当前时间小于1分钟的数据 减少处理的数据量

        return infoList;

    }



    public Result dingtou(DingtouInfo info) {
        //todo 执行定投逻辑 db中生成定投流水记录

        info.setDoneTime(info.getDoneTime()+1);
        info.setNextTime(info.calNextTime());


        log.info("user {} buy {} {}", info.getUserId(), info.getStock().getName(), info.getRule().getMoney());
        return Result.success();
    }

}
