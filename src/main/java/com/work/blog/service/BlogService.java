package com.work.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.work.blog.domain.Blog;
import com.work.blog.domain.Catalog;
import com.work.blog.domain.User;

/**
 * 用户博客服务接口
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
public interface BlogService {
    /**
     * 保存Blog
     * @param blog
     * @return
     */
	Blog saveBlog(Blog blog);
	
	/**
	 * 删除Blog
	 * @param id
	 * @return
	 */
	void removeBlog(Long id);
	
	/**
	 * 根据id获取Blog
	 * @param id
	 * @return
	 */
	Blog getBlogById(Long id);
	/**
	 * 查询用户最新的博客
	 * @param user
	 * @param title
	 * @param pageable
	 * @return
	 */
	Page<Blog> listBlogsByTitleNews(User user, String title, Pageable pageable);
	
	
	/**
	 * 查询用户最热的博客
	 * @param user
	 * @param title
	 * @param pageable
	 * @return
	 */
	Page<Blog> listBlogsByTitleVote(User user, String title, Pageable pageable);
	/**
	 * 获取用户分类下的博客列表
	 * @param catalog
	 * @param pageable
	 * @return
	 */
	Page<Blog> listBlogsByCatalog(Catalog catalog, Pageable pageable); 
	/**
	 * 阅读量递增
	 * @param id
	 */
	void readingIncrease(Long id);
	
	/**
	 * 发表评论
	 * @param blogId
	 * @param commentContent
	 * @return
	 */
	Blog createComment(Long blogId, String commentContent);
	
	/**
	 * 删除评论
	 * @param blogId
	 * @param commentId
	 * @return
	 */
	void removeComment(Long blogId, Long commentId);
	
	/**
	 * 点赞
	 * @param blogId
	 * @return
	 */
	Blog createVote(Long blogId);
	
	/**
	 * 取消点赞
	 * @param blogId
	 * @param voteId
	 * @return
	 */
	void removeVote(Long blogId, Long voteId);
}

