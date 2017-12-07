package com.shop.userservice.manage.response;

public class Response {

    public static final String OK = "ok";
    public static final String ERROR = "error";
    private final Meta meta;
    private final Object data;

    Response(Meta meta, Object data) {
        this.meta = meta;
        this.data = data;
    }

    /**
     * 成功，带数据
     * @param data
     * @return
     */
    public static Response success(Object data) {
        return new Response(new Meta(true, OK), data);
    }

    /**
     * 成功，带数据和消息
     * @param data
     * @param message
     * @return
     */
    public static Response success(Object data, String message) {
        return new Response(new Meta(true, message), data);
    }

    /**
     * 成功，带默认消息ok
     * @return
     */
    public static Response success() {
        return new Response(new Meta(true, OK), null);
    }

    public static Response failure(String message) {

        return new Response(new Meta(false, message), null);
    }

    public static Response failure(Object data, String message) {
        return new Response(new Meta(false, message), data);
    }

    public static Response failure() {
        return new Response(new Meta(false, ERROR), null);
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return this.data;
    }
}
