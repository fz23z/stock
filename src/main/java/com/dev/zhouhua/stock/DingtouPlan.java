package com.dev.zhouhua.stock;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 定投计划
 */
@Setter
@Getter
@Builder
public class DingtouPlan {

    private String userId;

    private DingtouRule rule;

    private Stock stock;

    /**
     * 最近一次次定投时间
     */
    private Date lastDoneTime;




    /**
     * 是否满足定投条件
     * 
     * @return
     */
    public boolean isTodo() {
        if (null != lastDoneTime) {
            if (isDoneToday()) {
                return false;
            }
        }
        return isDingtouDay();

    }

    /**
     * 今日是否已经定投过
     * 
     * @return
     */
    private boolean isDoneToday() {
        return DateUtils.isSameDay(lastDoneTime, Calendar.getInstance().getTime());
    }

    /**
     * 是否定投日
     * @return
     */
    private boolean isDingtouDay() {
        if (rule.getPeriod() == DingtouPeriod.DAY) {
            return true;
        }

        DateTime dateTime = new DateTime();

        if (rule.getPeriod() == DingtouPeriod.MONTH) {
            return dateTime.getDayOfMonth() == rule.getDayOfPeriod();
        } else if (rule.getPeriod() == DingtouPeriod.WEEK) {
            return dateTime.getDayOfWeek() == rule.getDayOfPeriod();
        }

        return true;
    }
}
