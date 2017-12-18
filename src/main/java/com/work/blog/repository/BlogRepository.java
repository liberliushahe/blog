package com.work.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.work.blog.domain.Blog;
import com.work.blog.domain.Catalog;
import com.work.blog.domain.User;

/**
 * 用户博客仓库接口
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {
	/**
	 * 通过用户和标题查询最新的博客
	 * @param user
	 * @param title
	 * @param pageable
	 * @return
	 */
    Page<Blog>	findByUserAndTitleLikeOrderByCreateTimeDesc(User user,String title,Pageable pageable);
    /**
     * 通过类别查询用户博客
     * @param catalog
     * @param pageable
     * @return
     */
    Page<Blog> findByCatalog(Catalog catalog,Pageable pageable);
	
}
