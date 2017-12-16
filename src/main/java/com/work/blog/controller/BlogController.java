package com.work.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 博客控制器类
 * 
 * @author jijiuxue <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月16日
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {
	/**
	 * 根据参数获取博客
	 * @param order
	 * @param keyword
	 * @param async
	 * @param index
	 * @param size
	 * @param model
	 * @return
	 */
	@GetMapping
	public String listESBlogs(@RequestParam(value = "order", required = false, defaultValue = "new") String order,
			                  @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
			                  @RequestParam(value = "async", required = false) boolean async,
			                  @RequestParam(value = "pageIndex", required = false,defaultValue = "0") int index,
			                  @RequestParam(value = "pageSize", required = false,defaultValue = "10") int size,
			                  Model model
			) {
		
		
		return "index";
	}
	/**
	 * 获取最新列表
	 * @param model
	 * @return
	 */
	@GetMapping("/neweslist")
	public String listNewestEsBlogs(Model model) {
		return "neweslist";
	}
	/**
	 * 获取最热列表
	 * @param model
	 * @return
	 */
	@GetMapping("/hoteslist")
	public String listHotestEsBlogs(Model model) {
		return "hoteslist";
	}
}
