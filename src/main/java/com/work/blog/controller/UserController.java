package com.work.blog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.work.blog.domain.User;
import com.work.blog.vo.Response;

/**
 * 用户控制器类
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
@Controller
@RequestMapping("/users")
public class UserController {
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
			@RequestParam(value="pageIndex",required=false,defaultValue="0") int index,
			@RequestParam(value="pageSize",required=false,defaultValue="10") int size,
			@RequestParam(value="name",required=false,defaultValue="") String name,
			Model model) {
				return null;
		
	}
	/**
	 * 新增用户
	 * @param user
	 * @param authorityId
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Response> create(User user, Long authorityId) {
		return ResponseEntity.ok().body(new Response(true,"增加成功",user));
	}
	/**
	 * 删除用户
	 * @param id
	 * @param model
	 * @return
	 */
	@DeleteMapping(value="del/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") int id,Model model){
	  
	return ResponseEntity.ok().body(new Response(true,"成功删除用户"));
	  
    }
	/**
	 * 编辑用户
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping(value="edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id,Model model){
	  
		return new ModelAndView("users/edit", "userModel", model);
	  
    }
}
