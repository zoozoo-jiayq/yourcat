package com.yourcat.yourcat._frame;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.yourcat.yourcat.admin.user.User;
import com.yourcat.yourcat.admin.user.UserService;

@Component
public class UserDetailImpl implements UserDetailsService {

	@Resource
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<User> us = userService.findByName(username);
		if(us.size()!=1) {
			return new org.springframework.security.core.userdetails.User(username,"",false,false,false,false,new HashSet<>());
		}else {
			Set set = new HashSet<>();
			set.add(new SimpleGrantedAuthority("ROLE_"+us.get(0).getRole()));
			return new org.springframework.security.core.userdetails.User(us.get(0).getName(),us.get(0).getPassword(),set);
		}
		
	}

}
