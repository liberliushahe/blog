package com.work.blog.service;

import com.work.blog.domain.Comment;

/**
 * 用户评论服务接口
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
public interface CommentService {
	/**
	 * 通过编号获取评论
	 * @param id
	 * @return
	 */
	Comment getCommentById(Long id);
	/**
	 * 通过编号删除评论
	 * @param id
	 */
	void removeCommentById(Long id);
}

