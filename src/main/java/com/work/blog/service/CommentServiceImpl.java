package com.work.blog.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.work.blog.domain.Comment;
import com.work.blog.repository.CommentRepository;

public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;
	@Override
	public Comment getCommentById(Long id) {
		// TODO Auto-generated method stub
		return commentRepository.getOne(id);
	}

	@Override
	public void removeCommentById(Long id) {
		// TODO Auto-generated method stub
		commentRepository.delete(id);
	}

}
