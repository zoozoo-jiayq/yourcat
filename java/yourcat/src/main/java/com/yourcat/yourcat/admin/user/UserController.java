package com.yourcat.yourcat.admin.user;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping("/index")
	public String index() {
		return "success";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/app/index")
	public String appIndex() {
		return "appindex";
	}

	@RequestMapping("/errorforbid")
	public String error() {
		return "error111";
	}
}
