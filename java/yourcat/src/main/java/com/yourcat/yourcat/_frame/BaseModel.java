package com.yourcat.yourcat._frame;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseModel implements Serializable {

	@Id
	private String id;
	private Timestamp insertTime;
}
