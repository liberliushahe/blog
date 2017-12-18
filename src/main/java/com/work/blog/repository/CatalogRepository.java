package com.work.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.blog.domain.Catalog;
import com.work.blog.domain.User;
/**
 * 用户目录仓库接口
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
public interface CatalogRepository extends JpaRepository<Catalog, Long> {
	/**
	 * 通过用户查询
	 * @param user
	 * @return
	 */
	List<Catalog> findByUser(User user);
	/**
	 * 根据用户和姓名查询
	 * @param user
	 * @param name
	 * @return
	 */
	List<Catalog> findByUserAndName(User user,String name);

}
