package com.work.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.work.blog.domain.Blog;
import com.work.blog.domain.Catalog;
import com.work.blog.domain.User;

public class BlogServiceImpl implements BlogService {

	@Override
	public Blog saveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBlog(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Blog getBlogById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Blog> listBlogsByTitleVote(User user, String title, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Blog> listBlogsByCatalog(Catalog catalog, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readingIncrease(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Blog createComment(Long blogId, String commentContent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeComment(Long blogId, Long commentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Blog createVote(Long blogId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeVote(Long blogId, Long voteId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Page<Blog> listBlogsByTitleNews(User user, String title, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
