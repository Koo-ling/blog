package com.blog.utils;

import com.blog.model.User;
import com.blog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;




public class MemberService implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String name) {

		System.out.println(name);
		User member= userService.findByName(name);
		if(member == null){
			throw new UsernameNotFoundException("用户名不存在");
		}
		return member;
	}

}
