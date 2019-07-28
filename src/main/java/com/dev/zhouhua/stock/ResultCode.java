package com.dev.zhouhua.stock;



public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS("200","成功"),

    /**
     * 失败
     */
    FAIL("100","失败");


    private String code;

    private String msg;


    ResultCode(String code,String msg){
        this.code = code;
        this.msg = msg;

    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
