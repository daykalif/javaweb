package com.itheima;

import com.example.*;
import com.itheima.utils.AliyunOSSThirdOperator;
import com.itheima.utils.AliyunOSSProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/*
 * 自动配置实现方案一：@ComponentScan
 * 		@ComponentScan(basePackages = {"com.itheima", "com.example"})
 * 		扫描指定包下的所有组件, 包括第三方的组件，如果定义了@ComponentScan，@SpringBootApplication扫描会失效
 *
 * 自动配置实现方案二：@Import
 * 		@Import(HeaderParser.class)	// 导入普通类
 * 		@Import(HeaderConfig.class)	// 导入配置类
 * 		@Import(MyImportSelector.class)    // ImportSelector实现类 - 批量导入
 *		@EnableXxx
 * 			第三方组件开发人员透出的配置，如：@EnableHeaderConfig
 */
@Import(HeaderConfig.class)
@ServletComponentScan // 开启了SpringBoot对Servlet组件的支持
@SpringBootApplication    // 具备组件扫描功能，默认扫描当前包（该项目中指的是com.itheima这个包）及其子包
public class TliasWebManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TliasWebManagementApplication.class, args);
	}

	/**
	 * 方式一：启动类中声明第三方bean
	 */
	@Bean
	public AliyunOSSThirdOperator getAliyunOSSOperatorThird(@Autowired AliyunOSSProperties aliyunOSSProperties) {
		return new AliyunOSSThirdOperator(aliyunOSSProperties);
	}
}
