package com.itheima.config;

import com.itheima.interceptor.DemoInterceptor;
import com.itheima.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类
 */
@Configuration    // 标识当前类是一个配置类，底层也用到了@Component，来将该类交给Spring容器IOC管理
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private DemoInterceptor demoInterceptor;

	@Autowired
	private TokenInterceptor tokenInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor).addPathPatterns("/**");    // 拦截所有请求

		registry.addInterceptor(tokenInterceptor)
				.addPathPatterns("/**") // 拦截所有请求
				.excludePathPatterns("/login"); // 不拦截哪些请求；	如果增加了这行，就可以注释TokenInterceptor中拦截/login的代码了
	}
}
