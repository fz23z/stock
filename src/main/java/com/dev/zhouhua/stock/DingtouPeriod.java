package com.dev.zhouhua.stock;

import lombok.Getter;

@Getter
public enum DingtouPeriod {

    /**
     * 日
     */
    DAY("day", "日"),

    /**
     * 周
     */
    WEEK("week", "周"),

    /**
     * 月
     */
    MONTH("month", "月");

    private final String name;

    private final String desc;

    DingtouPeriod(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

}
