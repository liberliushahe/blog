package com.work.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.blog.domain.Catalog;
import com.work.blog.domain.User;
import com.work.blog.repository.CatalogRepository;
/**
 * 用户分类服务接口实现类
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
@Service
public class CatalogServiceImpl implements CatalogService {
	
	@Autowired
	private CatalogRepository catalogRepository;
	@Override
	public Catalog saveCatalog(Catalog catalog) {
		// TODO Auto-generated method stub
		return catalogRepository.save(catalog);
	}

	@Override
	public Catalog getCatalogById(Long id) {
		// TODO Auto-generated method stub
		return catalogRepository.findOne(id);
	}

	@Override
	public void removeCatalogById(Long id) {
		// TODO Auto-generated method stub
		catalogRepository.delete(id);
	}

	@Override
	public List<Catalog> listUserCatalogs(User user) {
		// TODO Auto-generated method stub
		return catalogRepository.findByUser(user);
	}

}
