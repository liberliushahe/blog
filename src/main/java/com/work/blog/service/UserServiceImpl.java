package com.work.blog.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	@Transactional
	@Override
	public void removeUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}
	@Transactional
	@Override
	public void removeUsersInBatch(List<User> users) {
		// TODO Auto-generated method stub
		userRepository.deleteInBatch(users);
	}
	@Transactional
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
		return userRepository.findByNameLike(name, pageable);
	}

	@Override
	public List<User> listUsersByUsernames(Collection<String> usernames) {
		// TODO Auto-generated method stub
		return userRepository.findByUsernameIn(usernames);
	}

}
