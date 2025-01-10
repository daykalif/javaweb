package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 小结：
 * 	1.如何将一个类交给IOC容器管理？
 * 		- @Component（注意：是加在实现类上，而非接口上）
 * 	2.如何从IOC容器中找到该类型的bean，然后完成依赖注入？
 * 		- @Autowired
 */
@SpringBootApplication
public class SpringbootWebDemo03Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebDemo03Application.class, args);
	}
}
