package com.itheima.utils;

/**
 * 定义ThreadLocal操作工作类，存储当前线程的当前登录用户id
 */
public class CurrentHolder {

	private static final ThreadLocal<Integer> CURRENT_LOCAL = new ThreadLocal<>();

	public static void setCurrentId(Integer employeeId) {
		CURRENT_LOCAL.set(employeeId);
	}

	public static Integer getCurrentId() {
		return CURRENT_LOCAL.get();
	}

	public static void remove() {
		CURRENT_LOCAL.remove();
	}
}
