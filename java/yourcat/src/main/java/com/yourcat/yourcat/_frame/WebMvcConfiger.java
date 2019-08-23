package com.yourcat.yourcat._frame;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebMvcConfiger implements WebMvcConfigurer {

	@Value("${static.endpoint}")
	private String allowedOrigins;
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/**").allowedOrigins(allowedOrigins).allowedMethods("*").allowedHeaders("*").allowCredentials(true)
		.exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(24*3600);
	}
}
