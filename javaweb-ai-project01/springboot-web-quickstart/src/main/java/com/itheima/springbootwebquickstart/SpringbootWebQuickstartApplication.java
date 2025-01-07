package com.itheima.springbootwebquickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 启动该java文件，启动成功后，访问http://localhost:8080/hello?name=zhangsan即可
 *
 * 总结：
 * 	1.SpringBootWeb快速入门步骤：
 * 		a.创建SpringBoot工程，勾选web开发依赖。
 * 		b.定义请求处理类HelloController，定义请求处理方式
 * 		c.运行启动类，测试
 */
@SpringBootApplication
public class SpringbootWebQuickstartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebQuickstartApplication.class, args);
	}

}
