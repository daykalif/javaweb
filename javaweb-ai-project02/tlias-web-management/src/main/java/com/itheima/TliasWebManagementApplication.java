package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 开启了SpringBoot对Servlet组件的支持
@SpringBootApplication    // 默认扫描当前包（该项目中指的是com.itheima这个包）及其子包
public class TliasWebManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TliasWebManagementApplication.class, args);
	}

}
