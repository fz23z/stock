package com.dev.zhouhua.stock;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DingtouRule {

    private DingtouPeriod period;

    /**
     * 周期中的哪一天 如：每周三 每月十号
     *
     * 周期为周 1-7 周一至周日
     * 周期为月 1-31 一号到三十一号
     */
    private int dayOfPeriod;

    private BigDecimal money;

}
