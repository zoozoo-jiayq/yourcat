package com.yourcat.yourcat._frame;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.yourcat.yourcat.app.user.User;
import com.yourcat.yourcat.app.user.UserService;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

	@Resource
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<User> us = userService.findByName(username);
		if(us.size()!=1) {
			return new UserDetailsImpl(null);
		}else {
			return new UserDetailsImpl(us.get(0));
		}
		
	}

}
