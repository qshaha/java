package com.bilibilimao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bilibilimao.mapper.MenuMapper;
import com.bilibilimao.mapper.RoleMenuMapper;
import com.bilibilimao.po.Menu;
import com.bilibilimao.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private RoleMenuMapper roleMenuMapper;
	@Autowired
	private MenuMapper menuMapper;
	@Override
	public List<Menu> showMain(int roleId) {
		List<Integer> list = roleMenuMapper.findMenuIdByRoleId(roleId);
		Map<List<Integer>, List<Integer>> map = new HashMap<List<Integer>, List<Integer>>();
		map.put(list, list);
		List<Menu> list2 = menuMapper.findMenuByPid(map);
		return(list2);
	}
}