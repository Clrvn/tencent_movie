package com.enums;


public enum ResultFailureEnum {
    /**
     * 登录失败
     */
    LOGIN_ERROR(1, "登录失败"),
    
    /**
     * 没有登录
     */
    NOT_LOGIN(2, "没有登录"),
    
    /**
     * 添加好友失败
     */
    ADD_Friend_Failure(3, "添加好友失败"),
    ;
    
    private Integer state;
    private String message;
    
    ResultFailureEnum(Integer state, String message) {
        this.state = state;
        this.message = message;
    }
    
    public Integer getState() {
        return state;
    }
    
    public String getMessage() {
        return message;
    }
}
