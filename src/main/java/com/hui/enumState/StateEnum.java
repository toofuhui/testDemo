package com.hui.enumState;

public enum StateEnum {
    OPEN(1,"开启"),CLOSE(0,"关闭");
    private  Integer code;
    private  String msg;
    StateEnum(Integer code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String toString(String msg){
        return this.msg;
    }
}
