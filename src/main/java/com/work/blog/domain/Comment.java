package com.work.blog.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String content;
	private User user;
	private Timestamp createTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
    
}
