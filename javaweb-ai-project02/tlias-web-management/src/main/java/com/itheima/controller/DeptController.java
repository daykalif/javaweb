package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * @RestController用于标识当前类是spring控制层的类，也就是一个请求处理类；
 *
 * @RestController = @Controller + @ResponseBody
 *
 * @Controller：将控制层的类也交给IOC容器管理
 * @ResponseBody：标识当前方法的返回值，直接作为响应体返回给浏览器；如果返回值是一个对象，则默认转换为json格式返回；
 */
@RestController
public class DeptController {
	@Autowired        // Controller层需要调用Service层，则依赖注入service；应用程序运行时，会自动的查询该类型的bean对象，并赋值给该成员变量
	private DeptService deptService;

	@GetMapping("/depts")    //	@RequestMapping(value = "/depts", method = RequestMethod.GET)
	public Result list() {
		System.out.println("查询全部部门");
		List<Dept> deptList = deptService.findAll();
		return Result.success(deptList);
	}
}
