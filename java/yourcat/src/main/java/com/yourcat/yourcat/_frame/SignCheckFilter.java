package com.yourcat.yourcat._frame;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.yourcat.yourcat._util.Utils;

@WebFilter(filterName = "webFilter",urlPatterns = {"/*"})
public class SignCheckFilter implements Filter {
	private static String INVALID_PARAMETER = "signparameterinvalid";//签名参数不正确
	private static String SIGN_TIMEOUT = "signtimeout";//签名超时
	private static String SIGN_ERROR = "signerror";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletResponse res = (HttpServletResponse)response;
		String originSign = request.getParameter("sign");
		if(StringUtils.isEmpty(originSign)) {
			res.sendError(Response.SC_BAD_REQUEST,INVALID_PARAMETER);
			return;
		}
		
		String timestamp = request.getParameter("timestamp");
		if(StringUtils.isEmpty(timestamp)) {
			res.sendError(Response.SC_BAD_REQUEST,INVALID_PARAMETER);
			return;
		}
		long ts = Long.parseLong(timestamp);
		if(System.currentTimeMillis()-ts>5*60*1000) {
			res.sendError(Response.SC_BAD_REQUEST,SIGN_TIMEOUT);
			return;
		}
		
		Map<String,String[]> params = request.getParameterMap();
		Map<String,String> p = new HashMap<String,String>();
		for(String key:params.keySet()) {
			if(!key.equals("sign") && params.get(key)!=null && params.get(key).length>0 && !StringUtils.isEmpty(params.get(key)[0])) {
				p.put(key, params.get(key)[0]);
			}
		}
		String queryString = Utils.generateQueryStringByOrder(p);
		String sign =  Utils.md5(queryString);
		if(!sign.equals(originSign)) {
			res.sendError(Response.SC_BAD_REQUEST, SIGN_ERROR);
			return;
		}
		chain.doFilter(request, response);
	}

	
}
