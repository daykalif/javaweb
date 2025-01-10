package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/*
 * 小结：
 * 	1.依赖注入的注解：
 * 		- @Autowired：默认按照类型自动装配
 * 		- 如果同类型的bean存在多个：
 * 			- @Primary
 * 			- Autowired + @Qualifier
 * 			- @Resource
 *
 * 	2.@Resource 与 @Autowired区别？
 * 		- @Autowired是Spring框架提供的注解，而@Resource是J2EE规范提供的注解
 * 		- @Autowired默认按照类型注入，而@Resource默认按照名称注入
 */
@RestController
// @RestController底层用了@ResponseBody，其作用：将返回值作为响应体响应给客户端；如果返回值是对象/集合，会先转为json数据格式再响应给客户端；底层还用了@Controller注解
public class UserController {

	/*
	 * 方式一：属性注入（实际项目组通常会使用该方式）
	 *
	 *  @Qualifier("userServiceImpl3    )	// 多个bean对象，处理方式二：通过@Qualifier指定bean的id
	 *  @Autowired    //	应用程序运行时，会自动的查询该类型的bean对象，并赋值给该成员变量
	 * 	private UserService userService;        //	多态的使用方式
	 */

	@Resource(name = "userServiceImpl4")    // 多个bean对象，处理方式三：通过@Resource指定bean的name
	private UserService userService;

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
	 *
	 * 	private UserService userService;
	 *
	 *  @Autowired
	 *  public void setUserService(UserService userService) {
	 * 		this.userService = userService;
	 *  }
	 */


	@RequestMapping("/list")
	public List<User> list() {
		// 1.调用service，获取数据
		List<User> userList = userService.findAll();

		//	2.返回数据
		return userList;
	}
}
