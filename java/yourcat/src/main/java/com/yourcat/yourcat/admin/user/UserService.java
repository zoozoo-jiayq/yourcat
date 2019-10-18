package com.yourcat.yourcat.admin.user;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yourcat.yourcat._frame.BaseDao;
import com.yourcat.yourcat._frame.BaseServiceProxy;

@Service
@Transactional
public class UserService extends BaseServiceProxy<User> {

	@Resource
	private UserDao userDao;
	
	@Override
	public BaseDao<User> getBaseDao() {
		// TODO Auto-generated method stub
		return userDao;
	}

	public List<User> findByName(String name) {
		List<User> users = userDao.findByUserName(name);
		return users;
	}
	
	public Page<User> findList(String searchKey,Pageable page){
		return userDao.findByNickNameLikeOrUserNameLike("%"+searchKey+"%", "%"+searchKey+"%", page);
	}
}
