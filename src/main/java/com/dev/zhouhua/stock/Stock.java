package com.dev.zhouhua.stock;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Setter
@Getter
@Builder
public class Stock {


    private String id;

    private String no;

    private String name;

    private BigDecimal price;



}
