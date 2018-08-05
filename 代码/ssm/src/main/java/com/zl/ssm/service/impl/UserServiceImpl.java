package com.zl.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zl.ssm.dao.UserDao;
import com.zl.ssm.model.User;
import com.zl.ssm.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Resource(name = "userDao")
	private UserDao userDao; 
	

	@Override
	public User getUserById() {
		User user= userDao.getUserById("00002");
//		User user = new User();
//		user.setId("123123");
//		user.setName("账单");
//		user.setAge(16);;
		
		return user;
	}

}
