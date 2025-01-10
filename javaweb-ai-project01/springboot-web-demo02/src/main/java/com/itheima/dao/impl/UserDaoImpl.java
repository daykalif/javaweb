package com.itheima.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.itheima.dao.UserDao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现类
 */
public class UserDaoImpl implements UserDao {
	@Override
	public List<String> findAll() {
		//	1.加载并读取user.txt文件，来获取用户数据
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
		ArrayList<String> lines = IoUtil.readUtf8Lines(in, new ArrayList<>());
		return lines;
	}
}
