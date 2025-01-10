package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 小结：
 * 	1.声明bean的注解有哪几个？
 * 		- @Controller
 * 		- @Service
 * 		- @Repository
 * 		- @Component
 *  2.注意事项
 * 		- 在Springboot集成web开发中，声明控制器bean只能用@Controller注解。
 * 		- 声明bean的注解要想生效，需要被扫描到，启动类默认扫描当前包及其子包。
 */
@SpringBootApplication    // 默认扫描当前包（该项目中指的是com.itheima这个包）及其子包
public class SpringbootWebDemo4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebDemo4Application.class, args);
	}

}
