package com.dev.zhouhua.practise.factorymode;

import lombok.Getter;

/**
 * @author jiangyanyan
 * @since 2019/8/20 上午10:12
 *
 *        code格式 ABBCCC
 *
 *        A：错误级别 1-表示系统级错误，2-表示服务级错误
 *
 *        BB：代表错误项目或者模块号，从00开始。
 *
 *        CCC：具体错误编号，自增，从001开始。
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
