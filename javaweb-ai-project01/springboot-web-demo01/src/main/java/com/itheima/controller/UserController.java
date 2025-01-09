package com.itheima.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.itheima.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 请求处理类
 *
 * 用户信息Controller
 *
 * 1.静态资源文件存放位置
 * 	- resources/static
 *
 * 2.@ReponseBody注解的作用
 *  - 将controller方法的返回值直接写入HTTP响应体
 *  - 如果是对象或集合，会先转为json，再响应
 *  - @RestController = @Controller + @ResponseBody
 */
@RestController    // @RestController底层用了@ResponseBody，其作用：将返回值作为响应体响应给客户端；如果返回值是对象/集合，会先转为json数据格式再响应给客户端
public class UserController {
	@RequestMapping("/list")
	public List<User> list() {
		//	1.加载并读取user.txt文件，来获取用户数据

		// 不推荐。因为磁盘路径写死了
		//InputStream in = new FileInputStream(new File("/Users/daykalif/Desktop/web-project/javaweb-ai-project01/springboot-web-demo01/src/main/resources/static/user.txt"));
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
		ArrayList<String> lines = IoUtil.readUtf8Lines(in, new ArrayList<>());

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
				})
				// 可以缩写为：.toList();
				.collect(Collectors.toList());

		//	3.使用json数据格式，返回数据
		return userList;
	}
}
