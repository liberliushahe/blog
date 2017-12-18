package com.work.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.blog.domain.Comment;
import com.work.blog.repository.CommentRepository;
/**
 * 用户评论接口实现类
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
@Service
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
