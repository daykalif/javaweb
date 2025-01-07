package com.itheima.springbootwebquickstart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController    // 表示当前类为请求处理类
public class HelloController {

	@RequestMapping("/hello")
	public String hello(String name) {
		System.out.println("hello world--->" + name);
		return "hello world：" + name;
	}
}
