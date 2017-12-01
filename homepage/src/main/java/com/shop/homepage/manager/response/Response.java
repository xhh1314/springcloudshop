package com.shop.homepage.manager.response;

public class Response {

	public static final String OK = "ok";
	public static final String ERROR = "error";
	private Meta meta;
	private Object data;

	/**
	 * @param data
	 * @return 
	 */
	public Response success(Object data) {
		this.meta = new Meta(true, OK);
		this.data = data;
		return this;
	}

	public Response success(Object data, String message) {
		this.meta = new Meta(true, message);
		this.data = data;
		return this;
	}

	public Response success() {
		this.meta = new Meta(true, OK);
		return this;
	}

	public Response failure(String message) {
		this.meta = new Meta(false, message);
		return this;
	}

	public Response failure(Object data, String message) {
		this.meta = new Meta(false, message);
		this.data = data;
		return this;
	}

	public Response failure() {
		this.meta = new Meta(false, ERROR);
		return this;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
