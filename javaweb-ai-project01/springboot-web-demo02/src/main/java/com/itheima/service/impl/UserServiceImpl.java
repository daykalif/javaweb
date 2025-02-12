package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.pojo.User;
import com.itheima.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();    //	多态的使用方式

	@Override
	public List<User> findAll() {
		//	1.调用dao，获取数据
		List<String> lines = userDao.findAll();

		//	2.解析用户信息，每一行数据封装为一个User对象 --> list集合
		List<User> userList = lines.stream().map(line -> {
			String[] parts = line.split(",");
			Integer id = Integer.parseInt(parts[0]);
			String username = parts[1];
			String password = parts[2];
			String name = parts[3];
			Integer age = Integer.parseInt(parts[4]);
			LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			return new User(id, username, password, name, age, updateTime);
		}).toList();

		return userList;
	}
}
