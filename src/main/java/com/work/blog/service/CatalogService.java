package com.work.blog.service;

import java.util.List;

import com.work.blog.domain.Catalog;
import com.work.blog.domain.User;

/**
 * 用户目录服务接口
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
public interface CatalogService {
	/**
	 * 增加分类
	 * @param catalog
	 * @return
	 */
	Catalog saveCatalog(Catalog catalog);
	/**
	 * 通过编号获取分类
	 * @param id
	 * @return
	 */
	Catalog getCatalogById(Long id);
	/**
	 * 通过编号删除分类
	 * @param id
	 */
	void removeCatalogById(Long id);
	/**
	 * 获取用户分类列表
	 * @param user
	 * @return
	 */
	List<Catalog> listUserCatalogs(User user);
}

