package com.work.blog.vo;

import java.io.Serializable;

/**
 * 菜单值对象
 * 
 * @author jijiuxue
 * @creation 2017年12月16日
 * @since 1.0.0
 */
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String url;

	public Menu(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
