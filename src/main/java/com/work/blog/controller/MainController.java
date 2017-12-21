package com.work.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.work.blog.domain.User;
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
	/**
	 * 返回访问根节点返回主页
	 * @return
	 */
	@GetMapping("/")
	public String root(){
		return "index";
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
}
