package com.shop.userservice.manage.response;

/**
 * @author 李浩
 * @date 2017/11/29
 */
public class Meta {

    private boolean success;
    private String message;
    public Meta(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }






}
