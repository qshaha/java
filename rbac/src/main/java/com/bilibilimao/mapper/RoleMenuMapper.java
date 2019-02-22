package com.bilibilimao.mapper;

import java.util.List;

public interface RoleMenuMapper {
	public List<Integer> findMenuIdByRoleId(int roleId);
}