package com.itheima.exception;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 * 全局异常处理器：
 *
 * 匹配原则：按照类的继承关系，从下往上匹配
 * 如果匹配到的异常处理器方法，就会执行这个方法，并返回结果给前端；不会继续匹配其他异常处理器方法；
 *
 * @RestControllerAdvice = @ControllerAdvice + @ResponseBody
 * @ResponseBody：会将方法的返回值，作为响应体，响应给客户端；如果是返回对象，则将对象转换为json格式再响应给客户端；
 */
@Slf4j    // 记录日志
@RestControllerAdvice    // 表示当前类是一个全局异常处理器
public class GlobalExceptionHandler {    // 类名可以随意定义
	/**
	 * 拦截所有异常
	 */
	@ExceptionHandler    // 标识这是一个异常捕获方法
	public Result handleException(Exception e) {    // 给前端返回的数据类型为：Result
		log.error("全局异常处理器，拦截到异常~", e);
		return Result.error("出错啦, 请联系管理员~");
	}


	/**
	 * 出现重复时抛出的异常
	 */
	@ExceptionHandler
	public Result handleDuplicateKeyException(DuplicateKeyException e) {
		log.error("程序出错啦~", e);

		String message = e.getMessage();
		int i = message.indexOf("Duplicate entry");    // 查找异常信息中关键字：“Duplicate entry”，从这个地方的索引开始查找我们要的信息

		String errMsg = message.substring(i);
		String[] arr = errMsg.split(" ");    // 根据空格开始切割字符串，得到一个数组

		return Result.error(arr[2] + " 已存在");    // 其中我们要查找的内容在索引2的位置，将信息返回给前端
	}

}
