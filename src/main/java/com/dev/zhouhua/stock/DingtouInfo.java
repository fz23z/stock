package com.dev.zhouhua.stock;

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

}
