package com.yourcat.yourcat.admin.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.yourcat.yourcat._frame.BaseDao;

@Repository
public interface UserDao extends BaseDao<User> {

	public List<User> findByUserName(String userName);

	public Page<User> findByNickNameLikeOrUserNameLike(String nickName,String UserName,Pageable page);
}
