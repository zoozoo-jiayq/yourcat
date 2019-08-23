package com.yourcat.yourcat._frame;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yourcat.yourcat.app.user.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseController {

	@ExceptionHandler
	@ResponseBody
	public Object exception(Exception e) {
		log.error(e.getMessage());
		return ERROR(e.getMessage());
	}
	
	protected Object SUCCESS(Object data) {
		Map<String,Object> result = new HashMap<>();
		result.put("status", HttpServletResponse.SC_OK);
		result.put("data",data);
		return result;
	}
	
	protected Object ERROR(Object data) {
		Map<String,Object> result = new HashMap<>();
		result.put("status", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		result.put("data", data);
		return result;
	}
	
	protected User getUser() {
		return ((UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
	}
	
}
