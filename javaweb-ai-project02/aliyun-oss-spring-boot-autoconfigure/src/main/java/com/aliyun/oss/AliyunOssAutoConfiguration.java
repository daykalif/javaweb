package com.aliyun.oss;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AliyunOSS的自动配置类
 */
@EnableConfigurationProperties(AliyunOSSProperties.class)    // 底层@Import注解可以将 AliyunOSSProperties 注册到IOC容器中
@Configuration
public class AliyunOssAutoConfiguration {
	@Bean
	@ConditionalOnMissingBean    // 条件注解：当IOC容器中不存在某个Bean时，才会注册这个Bean到IOC容器中
	public AliyunOSSOperator aliyunOSSOperator(AliyunOSSProperties aliyunOSSProperties) {
		return new AliyunOSSOperator(aliyunOSSProperties);
	}
}
