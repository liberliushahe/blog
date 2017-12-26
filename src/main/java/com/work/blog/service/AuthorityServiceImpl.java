package com.work.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.blog.domain.Authority;
import com.work.blog.repository.AuthorityRepository;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public Authority getAuthorityById(long id) {
		return authorityRepository.getOne(id);
	}

}
