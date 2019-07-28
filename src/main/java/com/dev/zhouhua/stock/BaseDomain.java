package com.dev.zhouhua.stock;


import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;


public class BaseDomain implements Serializable {
    public BaseDomain() {
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}