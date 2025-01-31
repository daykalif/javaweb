package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect    // 标记当前时一个AOP类
@Component    // 交给Spring IOC容器管理
public class RecordTimeAspect {

	@Around("execution(* com.itheima.service.impl.*.*(..))")    // 针对com.itheima.service.impl包及其子包下所有类的所有方法生效，方法的形参也是任意的
	public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
		//1. 记录方法运行的开始时间
		long begin = System.currentTimeMillis();

		//2. 执行原始的方法
		Object result = pjp.proceed();

		//3. 记录方法运行的结束时间, 记录耗时
		long end = System.currentTimeMillis();
		log.info("方法 {} 执行耗时: {}ms", pjp.getSignature(), end - begin);
		return result;
	}

}
