package com.yourcat.yourcat._frame;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.yourcat.yourcat.app.user.User;

public class UserDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}

	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set set = new HashSet<>();
		if(user!=null) {
			set.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
		}
		return set;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user==null?"":user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user==null?"":user.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
