package com.bilibilimao.service.impl;

import java.util.List;
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
	public User VerifyAccountPassword(User user) {
		List<User> list = userMapper.findUsers(user);
		if(list !=null && list.size() > 0) {
			return(list.get(0));
		}
		return null;
	}
}