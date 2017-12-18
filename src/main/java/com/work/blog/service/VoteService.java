package com.work.blog.service;

/**
 * 用户点赞服务接口
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
public interface VoteService {
	/**
	 * 通过编号删除
	 * @param id
	 */
	void removeVoteById(Long id);
	
}

