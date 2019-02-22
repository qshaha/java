package com.bilibilimao.mapper;

import java.util.List;
import com.bilibilimao.po.User;

public interface UserMapper {
	public List<User> findUsers(User user);
}