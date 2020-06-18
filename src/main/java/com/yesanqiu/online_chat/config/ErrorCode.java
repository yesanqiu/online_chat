package com.yesanqiu.online_chat.config;


public enum ErrorCode {

    NO_KONW_ERROR("200","未知错误"),
    REGISTRE_FAIL_EMPTY_PSW("201","注册失败-密码不能为空"),
    REGISTRE_FAIL_SHORT_PSW("202","注册失败-密码长度小于6个字符"),
    LOGIN_FAIL_EMPTY_ID("203","登录失败-账户不能为空"),
    LOGIN_FAIL_SHORT_ID("204","登录失败-账户长度小于10个字符"),
    LOGIN_FAIL_EMPTY_PSW("205","登录失败-密码长度小于6个字符"),
    LOGIN_FAIL_SHORT_PSW("206","登录失败-密码长度小于6个字符"),
    LOGIN_FAIL_ERROR_PSW("207","登录失败-密码不匹配"),
    UNLOGIN("208","未登录"),

    ;

    private String code;
    private String msg;

    private ErrorCode(String code,String msg){
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
