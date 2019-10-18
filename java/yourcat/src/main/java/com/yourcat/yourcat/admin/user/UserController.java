package com.yourcat.yourcat.admin.user;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yourcat.yourcat._frame.BaseController;
import com.yourcat.yourcat._frame.BasePage;
import com.yourcat.yourcat._util.Utils;

@RestController
public class UserController extends BaseController {
	
	private static String LOGINFAIL = "loginfail";
	
	@Resource
	private RedisTemplate<String, User> redisTemplate;
	@Resource
	private UserService userService;
	@Value("${app.admin.default-password}")
	private String defaultPassword; 
	
	@PostMapping("/login")
	public Object login(@RequestBody User user) throws IOException {
		List<User> users = userService.findByName(user.getUserName());
		if(users.size()==0) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, LOGINFAIL);
			return null;
		}
		User u = users.get(0);
		if(u.getPassword().equals(Utils.md5(user.getPassword()))) {
			u.setLastVisitTime(new Date(System.currentTimeMillis()));
			userService.save(u);
			return u.getId();
		}else {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, LOGINFAIL);
			return null;
		}
	}
	
	@GetMapping("/get_info")
	public Object getLoginUserInfo(String token) {
		User u = userService.findById(token).get();
		return u;
	}
	
	@PostMapping("logout")
	public Object logout() {
		return null;
	}
	
	@GetMapping("/user/list")
	public Object list(String searchKey,BasePage basePage) {
		Page<User> page = userService.findList(searchKey, basePage.get());
		return page;
	}
	
	@PostMapping("/user/add")
	public Object addUser(@RequestBody User user) {
		if(StringUtils.isEmpty(user.getPassword())) {
			user.setPassword(Utils.md5(defaultPassword));
		}
		user = userService.save(user);
		return user;
	}

}
