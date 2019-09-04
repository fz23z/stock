package com.dev.zhouhua.stock;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
public class DingtouRule {


    private DingtouPeriod period;

    private BigDecimal money;

    private Date startTime;





}
