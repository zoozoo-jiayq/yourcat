package com.yourcat.yourcat.app.user;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourcat.yourcat._frame.BaseController;

@RestController
public class UserController extends BaseController {
	
	@Resource
	private RedisTemplate<String, String> redisTemplate;
	
	@GetMapping("/getLoginUserInfo")
	public Object getLoginUserInfo() {
		return SUCCESS(getUser());
	}

}
