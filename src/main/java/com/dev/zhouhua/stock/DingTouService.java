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
            Lists.newArrayList(DingtouInfo.builder().rule(rule1).stock(stock1).userId("123").build());

        return infoList;

    }

    public boolean isTimeUp(DingtouInfo info) {
        if (null == info || null == info.getRule()) {
            return false;
        }

        DingtouRule rule = info.getRule();

        // 第一次定投
        if (null == rule.getLastTime()) {
            DateTime dateTime = new DateTime(rule.getStartTime());
            return dateTime.isBeforeNow();
        }

        // 多次定投 m
        DateTime dateTime = new DateTime(rule.getLastTime());

        if (rule.getPeriod() == DingtouPeriod.MONTH) {
            dateTime.plusMonths(1);
        } else if (rule.getPeriod() == DingtouPeriod.WEEK) {
            dateTime.plusWeeks(1);
        } else {
            dateTime.plusDays(1);
        }

        return dateTime.isBeforeNow();
    }

    public Result dingtou(DingtouInfo info) {

        log.info("user {} buy {} {}", info.getUserId(), info.getStock().getName(), info.getRule().getMoney());
        return Result.instance();
    }

}
