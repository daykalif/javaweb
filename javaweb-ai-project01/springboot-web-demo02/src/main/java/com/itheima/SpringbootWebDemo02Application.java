package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 小结：
 * 	1.为什么要对代码进行拆分？
 * 		- 遵循单一职责原则，便于复用、后期维护
 * 	2.拆分为了哪三层？每一层的职责是什么？
 * 		- controller：接受请求，响应数据
 * 		- service：逻辑处理
 * 		- dao：数据访问层（数据持久层），获取数据
 */
@SpringBootApplication
public class SpringbootWebDemo02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebDemo02Application.class, args);
	}

}
