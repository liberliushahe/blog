package com.work.blog.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.work.blog.domain.User;
import com.work.blog.repository.UserRepository;

/**
 * 用户服务接口实现类
 * @author jijiuxue
 * <a href="https://github.com/liberliushahe/blog"></a>
 * @creation 2017年12月13日
 */
@Service
public class UserServiceImpl implements UserService,UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(rollbackOn=Exception.class)
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	@Transactional(rollbackOn=Exception.class)
	@Override
	public void removeUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}
	@Transactional(rollbackOn=Exception.class)
	@Override
	public void removeUsersInBatch(List<User> users) {
		// TODO Auto-generated method stub
		userRepository.deleteInBatch(users);
	}
	@Transactional(rollbackOn=Exception.class)
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);	
	}

	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Page<User> listUsersByNameLike(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		name="%"+name+"%";
		return userRepository.findByNameLike(name, pageable);
	}

	@Override
	public List<User> listUsersByUsernames(Collection<String> usernames) {
		// TODO Auto-generated method stub
		return userRepository.findByUsernameIn(usernames);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

}
