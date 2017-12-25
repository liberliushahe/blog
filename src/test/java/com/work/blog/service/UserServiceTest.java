package com.work.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
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
	/**
	 * 根据主键查询用户
	 */
	@Test
    public void findUserById() {
		User user=userServiceImpl.getUserById(1L);
		System.out.println(user.toString());
    }
	/**
	 * 增加用户
	 */
	@Test
	public void saveUser() {
		//User user=new User();
//		user.setEmail("XXXXXXXXX@qq.com");
//		user.setHeadimage("http://www.qq.com/head.jpg");
//		user.setName("wanggang");
//		user.setUsername("admin2");
//		user.setPassword("RRFRF&&^&&&&");
//		User addUser=userServiceImpl.saveUser(user);
//		System.out.println(addUser.toString());
	}
	/**
	 * 根据主键删除用户
	 */
	@Test
	public void removeUserById() {
		userServiceImpl.removeUser(1L);
	}
	/**
	 * 根据主键更新用户信息
	 */
	@Test
	public void updateUserById() {
		User user=userServiceImpl.getUserById(2L);
		user.setEmail("XXXXX@163.com");
		userServiceImpl.updateUser(user);
	}
	/**
	 * 根据姓名查询用户信息
	 */
	@Test
	public void findUserByNameLike(){
		Order order=new Order(Direction.DESC,"id");
		Sort sort=new Sort(order);
		Pageable pageable=new PageRequest(0,2,sort);
		Page<User> users=userServiceImpl.listUsersByNameLike("管理员", pageable);
		List<User> u=users.getContent();
		for(User u1:u){
			System.out.println(u1.toString());
		}
	}
	/**
	 * 根据用户名查询用户信息
	 */
	@Test
	public void findUserByUsername(){
		List<String> usernames=new ArrayList<String>();
		usernames.add("admin");
		usernames.add("admin2");
		List<User> u=userServiceImpl.listUsersByUsernames(usernames);
		for(User u1:u){
			System.out.println(u1.toString());
		}
	}
}
