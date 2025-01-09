package com.itheima.springbootwebquickstart;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 访问路径：http://localhost:8080/api?name=zhangsan&age=18
 *
 * 小结：
 * 	1.HTTP请求数据需要程序员自己解析吗？
 * 		- 不需要，web服务器负责对HTTP请求数据进行解析，并封装为了请求对象
 * 	2.如何获取请求数据？
 * 		- 通过HttpServletRequest对象获取，HttpServletRequest对象里面封装了所有的请求信息
 */
@RestController
public class RequestController {

	@RequestMapping("/api")
	public String request(HttpServletRequest request) {
		//	1.获取请求方式
		String method = request.getMethod();    // GET
		System.out.println("请求方式：" + method);

		//	2.获取请求url地址
		String url = request.getRequestURL().toString();    // http://localhost:8080/api
		System.out.println("请求url地址：" + url);
		String uri = request.getRequestURI();            // /api
		System.out.println("请求uri地址：" + uri);

		//	3.获取请求协议
		String protocol = request.getProtocol();    // HTTP/1.1
		System.out.println("请求协议：" + protocol);

		//	4.获取请求参数 - name
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("请求参数：" + name + "，" + age);

		//	5.获取请求头 - Accept
		String accept = request.getHeader("Accept");
		System.out.println("请求头：" + accept);

		return "给浏览器响应的数据";
	}
}
