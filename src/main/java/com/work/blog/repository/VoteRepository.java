package com.work.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.work.blog.domain.Catalog;
/**
 * 点赞仓库接口
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
public interface VoteRepository extends JpaRepository<Catalog, Long> {
	
}
