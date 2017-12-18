package com.work.blog.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
/**
 * 博客实体
 * @author jijiuxue <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月16日
 */
@Entity
public class Blog implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Size(min=3,max=50)
	@NotEmpty(message="标题不能为空")
	@Column(nullable=false,length=50)
	private String title;
    
	@NotEmpty(message = "摘要不能为空")
	@Size(min=2, max=300)
	@Column(nullable = false) 
	private String summary;
	
	/**
	 * markdown文本
	 */
	@Lob  
	@Basic(fetch=FetchType.LAZY) 
	@NotEmpty(message = "内容不能为空")
	@Size(min=2)
	@Column(nullable = false) 
	private String content;
	
	/**
	 * html文本
	 */
	@Lob  
	@Basic(fetch=FetchType.LAZY)
	@NotEmpty(message = "内容不能为空")
	@Size(min=2)
	@Column(nullable = false) 
	private String htmlContent; 
	
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	/**
	 * 创建时间
	 */
	@Column(nullable = false) 
	@org.hibernate.annotations.CreationTimestamp 
	private Timestamp createTime;
	
	/**
	 * 访问量、阅读量
	 */
	@Column(name="readSize")
	private Integer readSize = 0; 
	 
	/**
	 * 评论量
	 */
	@Column(name="commentSize")
	private Integer commentSize = 0;  

	/**
	 * 点赞量
	 */
	@Column(name="voteSize")
	private Integer voteSize = 0;  
	
	/**
	 * 评论
	 */
	@OneToMany()
	private List<Comment> comments;
	
	/**
	 * 点赞
	 */
	@OneToMany()
	private List<Vote> votes;
	
	/**
	 * 分类
	 */
	@OneToOne()
	private Catalog catalog;
	
	/**
	 * 标签
	 */
	@Column(name="tags", length = 100) 
	private String tags;  
}
