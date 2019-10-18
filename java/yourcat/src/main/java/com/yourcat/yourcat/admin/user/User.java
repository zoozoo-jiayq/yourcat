package com.yourcat.yourcat.admin.user;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yourcat.yourcat._frame.BaseModel;

import lombok.Data;

@Entity
@Data
public class User extends BaseModel {

	private String nickName;
	private String userName;
	private String password;
	private String role;
	private String phone;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date lastVisitTime;
	private Integer state;
	@Transient
	private List<String> access = new ArrayList<String>() {{this.add("admin");}};
	
}
