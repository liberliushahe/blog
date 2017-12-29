package com.work.blog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.work.blog.domain.Authority;
import com.work.blog.domain.User;
import com.work.blog.service.AuthorityService;
import com.work.blog.service.UserService;
import com.work.blog.util.ConstraintViolationExceptionHandler;
import com.work.blog.vo.Response;

/**
 * 用户控制器类
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
@RestController
@RequestMapping("/users")

public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorityService authorityService;
	/**
	 * 获取用户列表
	 * @param async
	 * @param index
	 * @param size
	 * @param name
	 * @param model
	 * @return
	 */
	@GetMapping
	public ModelAndView list(@RequestParam(value="async",required=false) boolean async,
			@RequestParam(value="pageIndex",required=false,defaultValue="8") int index,
			@RequestParam(value="pageSize",required=false,defaultValue="1") int size,
			@RequestParam(value="name",required=false,defaultValue="") String name,
			Model model) {
		    Pageable pageable=new PageRequest(index, size);	
		    Page<User> page=userService.listUsersByNameLike(name, pageable);
		    List<User> userlist=page.getContent();
		    model.addAttribute("page", page);
		    model.addAttribute("userlist", userlist);
			return new ModelAndView(async==true?"users/list :: #mainContainerRepleace":"users/list", "userModel", model);
		  
	}
	/**
	 * 获取新增用户 form 表单页面
	 * @param user
	 * @return
	 */
	@GetMapping("/add")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user", new User(null, null, null, null));
		return new ModelAndView("users/add", "userModel", model);
	}
	/**
	 * 新增用户
	 * @param user
	 * @param authorityId
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Response> create(User user, long authorityId) {
		List<Authority> listAuthority=new ArrayList<Authority>();
		Authority authority=authorityService.getAuthorityById(authorityId);
		listAuthority.add(authority);
		user.setAuthorities(listAuthority);
		User newuser=null;
		if(user.getId()==0){
			user.setEncodePassword(user.getPassword());
		}else{
			//判断用户是否修改了密码,如果修改了密码则相应的修改
			User modifyUser=userService.getUserById(user.getId());
			String oldPassword=modifyUser.getPassword();
			PasswordEncoder encoder=new BCryptPasswordEncoder();
			String newPassword=encoder.encode(user.getPassword());
			boolean isMatch=encoder.matches(oldPassword, newPassword);
			if(isMatch){
				user.setPassword(user.getPassword());
			}else{
				user.setEncodePassword(user.getPassword());
			}
		}
		try {
			userService.saveUser(user);
		}  catch (ConstraintViolationException e)  {
			return ResponseEntity.ok().body(new Response(false, ConstraintViolationExceptionHandler.getMessage(e)));
		}
	
		return ResponseEntity.ok().body(new Response(true,"操作成功",newuser));
	}
	/**
	 * 删除用户
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping(value="del/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") long id,Model model){
		try{
	       userService.removeUser(id);
	       }catch(Exception e){
			return ResponseEntity.ok().body(new Response(false,e.getMessage()));
		}
	        return ResponseEntity.ok().body(new Response(true,"成功删除用户"));
	  
    }
	/**
	 * 编辑用户
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping(value="edit/{id}")
    public ModelAndView edit(@PathVariable("id") long id,Model model){
		User user=userService.getUserById(id);
		System.out.println(user.toString());
		model.addAttribute("user",user);
		return new ModelAndView("users/edit", "userModel", model);
	  
    }
	
}
