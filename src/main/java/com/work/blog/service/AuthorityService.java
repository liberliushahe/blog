package com.work.blog.service;
import com.work.blog.domain.Authority;
/**
 * 用户权限服务接口
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
public interface AuthorityService {
	/**
	 * 获取用户权限
	 * @param id
	 * @return
	 */
	Authority getAuthorityById(long id);
}

