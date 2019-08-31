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

    private Result(ResultCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }


    private Result(ResultCode errorCode, T data) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }



    public boolean isSuccess() {
        return StringUtils.equals(this.getCode(), ResultCode.SUCCESS.getCode());
    }

    public static Result success() {
        return new Result();
    }

    public static <T> Result success(T data) {
        return new Result(data);
    }


    public static <T> Result fail(ResultCode resultCode) {
        return new Result(resultCode);
    }

    public static <T> Result fail(ResultCode resultCode, T data) {
        return new Result(resultCode, data);
    }



    public Map<String,Object> toJsonMap(){
        Map<String,Object> map = new HashMap();
        map.put("data",this.data);
        map.put("msg",this.msg);
        map.put("code",this.code);
        return  map;
    }

}
