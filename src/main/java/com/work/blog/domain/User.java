package com.work.blog.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
/**
 * 用户实体
 * @author jijiuxue <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
@Entity
public class User implements Serializable{

	/**
	 * 默认序列号
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(nullable=false,length=20)
	@Size(min=3,max=20)
	@NotEmpty(message="姓名不能为空")
    private String name;
	
	@NotEmpty(message="邮箱不能为空")
	@Column(nullable=false,length=50,unique=true)
	@Email(message="邮箱格式不正确")
	@Size(max=50)
    private String email;
	
	@NotEmpty(message="用户名不能为空")
	@Size(min=3,max=20)
	@Column(nullable=false,length = 20,unique=true)
    private String username;
	
	@NotEmpty(message="密码不能为空")
	@Size(max=100)
	@Column(length = 100)
    private String password;
	
	@Column(length=200)
    private String headimage;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHeadimage() {
		return headimage;
	}
	public void setHeadimage(String headimage) {
		this.headimage = headimage;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", headimage=" + headimage + "]";
	}
    
}
