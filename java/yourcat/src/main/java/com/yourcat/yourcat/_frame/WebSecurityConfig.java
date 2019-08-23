package com.yourcat.yourcat._frame;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Resource
	private UserDetailServiceImpl userDetailService;
	
	@Override
	protected UserDetailsService userDetailsService() {
		// TODO Auto-generated method stub
		return userDetailService;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.cors().and().csrf().disable()
		.authorizeRequests().anyRequest().authenticated().and()
		.formLogin().usernameParameter("username").passwordParameter("password").loginProcessingUrl("/login").failureHandler(new AuthenticationFailureHandler() {
			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {
				// TODO Auto-generated method stub
				Map<String,Object> r = new HashMap<>();
				r.put("status",HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				r.put("data", "账户名或者密码不正确!");
				response.getWriter().println(new Gson().toJson(r));
			}
		}).successHandler(new AuthenticationSuccessHandler() {
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				// TODO Auto-generated method stub
				Map<String,Object> r = new HashMap<>();
				r.put("status",HttpServletResponse.SC_OK);
				response.getWriter().println(new Gson().toJson(r));
			}
		})
		.and().exceptionHandling().accessDeniedHandler(new AccessDeniedHandler() {
			@Override
			public void handle(HttpServletRequest request, HttpServletResponse response,
					AccessDeniedException accessDeniedException) throws IOException, ServletException {
				// TODO Auto-generated method stub
				Map<String,Object> r = new HashMap<>();
				r.put("status",HttpServletResponse.SC_FORBIDDEN);
				r.put("data", "禁止访问!");
				response.getWriter().println(new Gson().toJson(r));
			}
		});
	}
}
