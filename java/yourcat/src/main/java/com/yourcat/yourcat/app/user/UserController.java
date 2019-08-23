package com.yourcat.yourcat.app.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourcat.yourcat._frame.BaseController;

@RestController
public class UserController extends BaseController {
	
	@GetMapping("/getLoginUserInfo")
	public Object getLoginUserInfo() {
		return SUCCESS(getUser());
	}

}
