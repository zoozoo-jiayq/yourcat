package com.yourcat.yourcat._frame;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import lombok.Data;

@Data
public class BasePage {
	private int page = 0;
	private int size = 10;
	private String direction = "desc";
	private String properties = "insertTime";
	
	public Pageable get() {
		return PageRequest.of(page, size, Direction.fromString(direction), properties);
	}
}
