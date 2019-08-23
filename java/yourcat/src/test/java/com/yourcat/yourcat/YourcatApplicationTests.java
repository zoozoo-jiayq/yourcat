package com.yourcat.yourcat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.SecurityNamespaceHandler;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.filter.CorsFilter;

import com.yourcat.yourcat.app.user.User;
import com.yourcat.yourcat.app.user.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YourcatApplicationTests {

	@Resource
	private UserService userService;
	
	@Test
	public void contextLoads() {
		User u = new User();
		u.setName("lisi");
		PasswordEncoder bc = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		pc = new  SCryptPasswordEncoder();
		String pwd = bc.encode("123456");
		u.setPassword(pwd);
		u.setRole("ADMIN");
		userService.save(u);
		
		User u1 = new User();
		u1.setName("zhangsan");
		pwd = bc.encode("123456");
		u1.setPassword(pwd);
		u1.setRole("USER");
		userService.save(u1);
	}
	
	void test(){
		SecurityNamespaceHandler handler = null;
		DataSourceBuilder db = null;
		
		WebAsyncManagerIntegrationFilter webAsyncManagerIntegrationFilter = null;
		SecurityContextPersistenceFilter securityContextPersistenceFilter = null;
		HeaderWriterFilter headerWriterFilter = null;
		CorsFilter corsFilter = null;
		LogoutFilter logoutFilter = null;
		UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter = null;
		DefaultLoginPageGeneratingFilter defaultLoginPageGeneratingFilter = null;
//		DefaultLogoutPageGeneratingFilte defaultLogoutPageGeneratingFilte = null;
		RequestCacheAwareFilter requestCacheAwareFilter = null;
		SecurityContextHolderAwareRequestFilter securityContextHolderAwareRequestFilter = null;
		SessionManagementFilter sessionManagementFilter = null;
		
		FilterSecurityInterceptor filterSecurityInterceptor = null;
	}
}
