package com.yourcat.yourcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class YourcatApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourcatApplication.class, args);
	}

}
