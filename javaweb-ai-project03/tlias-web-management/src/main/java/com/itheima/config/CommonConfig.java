package com.itheima.config;

import com.itheima.utils.AliyunOSSProperties;
import com.itheima.utils.AliyunOSSThirdOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 方式二：配置类中声明第三方bean
 */
@Configuration
public class CommonConfig {
	@Bean
	public AliyunOSSThirdOperator getAliyunOSSOperatorThird(@Autowired AliyunOSSProperties aliyunOSSProperties) {
		return new AliyunOSSThirdOperator(aliyunOSSProperties);
	}
}
