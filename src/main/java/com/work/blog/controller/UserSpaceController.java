package com.work.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.blog.domain.User;

/**
 * 用户主页控制器类
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月16日
 * @since 1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserSpaceController {
	@Autowired
	private UserDetailsService userDetailsService;
	/**
	 * 获取用户博客
	 * @param username
	 * @param model
	 * @return
	 */
	@GetMapping("{username}")
	public String userSpace(@PathVariable(value="username") String username,Model model){
	User user=(User)userDetailsService.loadUserByUsername(username);
	model.addAttribute("user", user);
		return "/userspace/user";
	}
	
	/**
	 * 获取用户的某一篇博客
	 * @param username
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/{username}/blogs/{id}")
	public String getBlogById(@PathVariable("username") String username,@PathVariable("id") Long id, Model model) {
		return null;
	}
	
}
