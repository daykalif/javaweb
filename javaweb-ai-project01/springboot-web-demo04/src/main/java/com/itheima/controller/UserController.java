package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
// @RestController底层用了@ResponseBody，其作用：将返回值作为响应体响应给客户端；如果返回值是对象/集合，会先转为json数据格式再响应给客户端；底层还用了@Controller注解
public class UserController {

	/*
	 * 方式一：属性注入（实际项目组通常会使用该方式）
	 *
	 * @Autowired    //	应用程序运行时，会自动的查询该类型的bean对象，并赋值给该成员变量
	 * private UserService userService;        //	多态的使用方式
	 */


	/*
	 * 方式二：构造器注入（官方推荐）
	 *
	 * 	private final UserService userService;    // final修饰：这个变量一旦初始化完毕，就不能被修改
	 *
	 *  @Autowired	// 如果当前类只存在一个构造器，则@Autowired可以省略
	 *  public UserController(UserService userService) {    // 快捷键：command + N
	 * 		this.userService = userService;
	 *  }
	 */


	/*
	 * 第三种方式：setter注入
	 */
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@RequestMapping("/list")
	public List<User> list() {
		// 1.调用service，获取数据
		List<User> userList = userService.findAll();

		//	2.返回数据
		return userList;
	}
}
