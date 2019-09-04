package com.dev.zhouhua.stock;

import java.util.Date;

import org.joda.time.DateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public  class DingtouInfo{

    private String userId;

    private DingtouRule rule;

    private Stock stock;

    /**
     * 下次定投时间
     */
    private Date nextTime;

    /**
     * 已投期数
     */
    private int doneTime;


    public Date calNextTime(){
        DateTime nextTime = new DateTime(rule.getStartTime());
        if (rule.getPeriod() == DingtouPeriod.MONTH) {
            nextTime.plusMonths(1);
        } else if (rule.getPeriod() == DingtouPeriod.WEEK) {
            nextTime.plusWeeks(1);
        } else {
            nextTime.plusDays(1);
        }
        return nextTime.toDate();

    }

    public boolean isTimeUp(){
        DateTime dateTime = new DateTime(nextTime);
        return dateTime.isBeforeNow();
    }

}
