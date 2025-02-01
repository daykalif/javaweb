package com.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderConfig {
	/*
	 * 自动配置原理：
	 * 1.假如我们需要当前环境存在jwts时，才初始化下面这个bean
	 *      @ConditionalOnClass(name = "io.jsonwebtoken.Jwts")    // 判断当前环境是否存在io.jsonwebtoken.Jwts这个类对应的字节码文件，如果有才注册bean到IOC容器中
	 *
	 * 2.判定环境中是否有对应的bean，没有就创建bean
	 * 		@ConditionalOnMissingBean
	 *
	 * 3.判断配置文件中有对应属性和值，才注册bean到IOC容器。
	 * 		@ConditionalOnProperty(name="myname", havingValue = "itheima")
	 */
	@Bean
	@ConditionalOnProperty(name="myname", havingValue = "itheima")
	public HeaderParser headerParser() {
		return new HeaderParser();
	}

	@Bean
	public HeaderGenerator headerGenerator() {
		return new HeaderGenerator();
	}
}
