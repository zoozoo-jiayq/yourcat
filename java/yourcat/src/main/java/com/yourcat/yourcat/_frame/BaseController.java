package com.yourcat.yourcat._frame;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseController {
	
	@Resource
	protected HttpServletResponse response;

	@ExceptionHandler
	@ResponseBody
	public Object exception(Exception e) throws IOException {
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		return null;
	}
	
}
