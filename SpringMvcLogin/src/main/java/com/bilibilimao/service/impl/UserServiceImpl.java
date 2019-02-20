package com.bilibilimao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bilibilimao.mapper.UserMapper;
import com.bilibilimao.po.User;
import com.bilibilimao.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User findUserByNameAndPassword(User user) {
		return(userMapper.findUserByNameAndPassword(user));
	}
}