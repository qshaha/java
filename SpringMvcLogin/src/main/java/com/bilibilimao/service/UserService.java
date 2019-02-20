package com.bilibilimao.service;

import com.bilibilimao.po.User;

public interface UserService {
	public User findUserByNameAndPassword(User user);
}