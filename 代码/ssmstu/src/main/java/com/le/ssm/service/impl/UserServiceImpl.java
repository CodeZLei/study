package com.le.ssm.service.impl;

import com.le.ssm.dao.UserDao;
import com.le.ssm.model.User;
import com.le.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;


    @Override
    public User getUserById() {
            User user = userDao.getUserById("00002");
//		User user = new User();
//		user.setId("123123");
//		user.setName("账单");
//		user.setAge(16);;

        return user;
    }

}
