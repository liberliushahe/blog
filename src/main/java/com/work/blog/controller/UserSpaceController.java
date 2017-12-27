package com.work.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户主页控制器类
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月16日
 * @since 1.0.0
 */
@Controller
public class UserSpaceController {
	/**
	 * 获取用户博客
	 * @param username
	 * @param model
	 * @return
	 */
	@GetMapping("{username}")
	public String userSpace(@PathVariable(value="username") String username,Model model){
		
		return null;
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
	@GetMapping("/logout")  
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {  
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
	    System.out.println("注销用户");
	    if (auth != null){      
	        new SecurityContextLogoutHandler().logout(request, response, auth);  
	    }  
	    return "redirect:/index?success"; 
	}  
}
