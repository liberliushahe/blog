package com.work.blog.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.work.blog.domain.User;

/**
 * 用户仓库接口
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
public interface UserRepository extends JpaRepository<User, Long>{
    /**
     * 通过姓名分页模糊查询
     * @param name
     * @param pageable
     * @return
     */
	Page<User> findByNameLike(String name,Pageable pageable);   
	/**
	 * 通过用户名查询用户
	 * @param username
	 * @return
	 */
	User findByUsername(String username);
	/**
	 * 根据名称列表查询
	 * @param usernames
	 * @return
	 */
	List<User> findByUsernameIn(Collection<String> usernames);
}
