package com.dev.zhouhua.practise.factorymode;

import lombok.Getter;

/**
 * @author jiangyanyan
 * @since 2019/8/20 上午10:12
 */
@Getter
public enum ErrorCode {


    /**
     * 员工类型不存存在
     */
    EmployeeTypeNotExist(1,"员工类型不存存在");



    private int code;

    private String msg;


    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
