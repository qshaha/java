package com.bilibilimao.mapper;

import java.util.List;
import java.util.Map;

import com.bilibilimao.po.Menu;

public interface MenuMapper {
	public List<Menu> findMenuByPid(Map<List<Integer>, List<Integer>> map);
}