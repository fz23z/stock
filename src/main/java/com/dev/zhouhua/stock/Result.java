package com.dev.zhouhua.stock;



import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
public class Result <T> extends BaseDomain {
    private String code;
    private String msg;
    private T data;

    private Result() {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
    }

    private Result(T data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.setData(data);
    }

    private Result(String code, String msg) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.setCode(code);
        this.setMsg(msg);
    }

    private Result(String code, String msg, T data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    public Result<T> setError(String code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }

    public Result<T> setError(ResultCode errorCode) {
        this.setCode(errorCode.getCode());
        this.setMsg(errorCode.getMsg());
        return this;
    }

    public boolean isSuccess() {
        return StringUtils.equals(this.getCode(), ResultCode.SUCCESS.getCode());
    }

    public static Result instance() {
        return new Result();
    }

    public static <T> Result instance(T data) {
        return new Result(data);
    }

    public static <T> Result instance(String code, String msg) {
        return new Result(code, msg);
    }

    public static <T> Result instance(String code, String msg, T data) {
        return new Result(code, msg, data);
    }

    public Map<String,Object> toJsonMap(){
        Map<String,Object> map = new HashMap();
        map.put("data",this.data);
        map.put("msg",this.msg);
        map.put("code",this.code);
        return  map;
    }

}
