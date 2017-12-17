package com.work.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.blog.domain.Comment;
/**
 * 用户评论仓库接口
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
