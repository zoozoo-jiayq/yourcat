package com.yourcat.yourcat.app.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yourcat.yourcat._frame.BaseDao;

@Repository
public interface UserDao extends BaseDao<User> {

	public List<User> findByName(String name);

}
