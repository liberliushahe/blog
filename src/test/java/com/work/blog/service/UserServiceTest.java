package com.work.blog.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.work.blog.domain.User;
import com.work.blog.service.UserService;
/**
 * 
 * @author Administrator
 * @creation 2017年12月16日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
   @Autowired
   private UserService userServiceImpl;
	//根据主键查询用户
	@Test
    public void findUserById() {
		User user=userServiceImpl.getUserById(1L);
		System.out.println(user.toString());
    }
	//增加用户
	@Test
	public void saveUser() {
		User user=new User();
		user.setEmail("XXXXXXXXX@qq.com");
		user.setHeadimage("http://www.qq.com/head.jpg");
		user.setName("wanggang");
		user.setUsername("admin2");
		user.setPassword("RRFRF&&^&&&&");
		User addUser=userServiceImpl.saveUser(user);
		System.out.println(addUser.toString());
	}
	//根据主键删除用户
	@Test
	public void removeUserById() {
		userServiceImpl.removeUser(1L);
	}
	//根据主键更新用户信息
	@Test
	public void updateUserById() {
		User user=userServiceImpl.getUserById(2L);
		user.setEmail("XXXXX@163.com");
		userServiceImpl.updateUser(user);
	}
}
