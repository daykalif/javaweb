package com.itheima.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component    //交给Spring容器IOC管理
public class DemoInterceptor implements HandlerInterceptor {
	//在目标资源方法运行之前运行 - 返回值: true 放行（放行表示执行目标资源）, false 不放行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("############################## preHandle ... ##################################");
		return true;
	}

	//在目标资源方法运行之后运行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		log.info("----------- postHandle ... ---------");
	}

	//视图渲染完毕后运行（以前前后端未分离项目的时候使用，现在已不常用）
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%% afterCompletion ... %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	}
}
