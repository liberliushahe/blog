package com.work.blog.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.work.blog.domain.Authority;
import com.work.blog.repository.AuthorityRepository;

public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public Authority getAuthorityById(long id) {
		return authorityRepository.getOne(id);
	}

}
