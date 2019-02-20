package com.bilibilimao.mapper;

import com.bilibilimao.po.User;

public interface UserMapper {
	public User findUserByNameAndPassword(User user);
}