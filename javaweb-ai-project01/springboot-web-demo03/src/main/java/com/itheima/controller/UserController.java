package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
	@Autowired    //	应用程序运行时，会自动的查询该类型的bean对象，并赋值给该成员变量
	private UserService userService;        //	多态的使用方式

	@RequestMapping("/list")
	public List<User> list() {
		// 1.调用service，获取数据
		List<User> userList = userService.findAll();

		//	2.返回数据
		return userList;
	}
}
