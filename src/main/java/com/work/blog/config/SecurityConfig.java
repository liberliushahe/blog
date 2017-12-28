package com.work.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 安全配置类
 * 
 * @author jijiuxue <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * 常量KEY
	 */
	private static final String KEY = "liushahe.com";
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;
    /**
     * 使用 BCrypt 加密
     * @return
     */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		// 设置密码加密方式
		authenticationProvider.setPasswordEncoder(passwordEncoder); 
		return authenticationProvider;
	}

	/**
	 * 自定义安全配置方法
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				// 允许静态文件通过
				.antMatchers("css/**", "js/**", "font/**", "img/**").permitAll().antMatchers("/console/**").permitAll()
				// 允许拥有管理员角色的用户访问
				.antMatchers("/admin/**").hasRole("ADMIN").and()
				// 表单登录以及登录界面和失败登录界面
				.formLogin().loginPage("/login").failureUrl("/login-error").and()
				// 启用记住我功能
				.rememberMe().key(KEY).and()
				// 处理异常 如果拒绝连接错误则跳转相应的页面
				.exceptionHandling().accessDeniedPage("/403");
		// 禁用 H2 控制台的 CSRF 防护
		http.csrf().ignoringAntMatchers("/console/**");
		// 由于默认启用了csrf防护导致post提交一直报405错误，暂时禁用
		 //http.csrf().disable();
		// 允许来自同一来源的H2 控制台的请求
		http.headers().frameOptions().sameOrigin();

	}

	/**
	 * 认证信息管理
	 * 
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}

}
