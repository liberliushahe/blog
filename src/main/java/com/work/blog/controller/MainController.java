package com.work.blog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.work.blog.domain.Authority;
import com.work.blog.domain.User;
import com.work.blog.service.AuthorityService;
import com.work.blog.service.UserService;

/**
 * 主页控制器类
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月16日
 */
@Controller
public class MainController {
	@Autowired
	private UserService userService;
	@Autowired
	private AuthorityService authorityService;
	/**
	 * 设置注册用户默认角色
	 */
	private static final Long ROLE_USER_AUTHORITY_ID = 2L;
	/**
	 * 返回访问根节点返回主页
	 * @return
	 */
	@GetMapping("/")
	public String root(){
		return "redirect:/index";
	}
	/**
	 * 访问首页返回主页
	 * @return
	 */
	@GetMapping("/index")
	public String index() {
		return "redirect:/blogs";
	}
	/**
	 * 登录界面
	 * @return
	 */
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	/**
	 * 登录失败跳转页面
	 * @return
	 */
	@GetMapping("/login-error")
	public String loginError(Model model){
		model.addAttribute("loginError", true);
		model.addAttribute("errorMsg","用户名或者密码错误");
		return "login";
	}
	/**
	 * 跳转至注册界面
	 * @return
	 */
	@GetMapping("/register")
	public String register(){
	    return "register";	
	}
	/**
	 * 用户注册
	 * @return
	 */
	@PostMapping("/register")
	public String userRegister(User user){
		List<Authority> list=new ArrayList<Authority>();
		Authority authority=authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID);
		list.add(authority);
		user.setAuthorities(list);
		userService.saveUser(user);
		return "redirect:/login";
	}
	/**
	 * 搜索界面
	 * @return
	 */
	@GetMapping("/search")
	public String search(){
		return "search";
		
	}
	/**
	 * 注销用户
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping("/logout")  
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {  
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
	    if (auth != null){      
	        new SecurityContextLogoutHandler().logout(request, response, auth);  
	    }  
	    return "redirect:/index"; 
	}  
}
