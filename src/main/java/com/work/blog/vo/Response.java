package com.work.blog.vo;
/**
 * 返回数据类
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
public class Response {
	
	
	private boolean success;
	private String message;
	private Object body;
	

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
	
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}

	public Response(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	public Response(boolean success, String message, Object body) {
		this.success = success;
		this.message = message;
		this.body = body;
	}

}
