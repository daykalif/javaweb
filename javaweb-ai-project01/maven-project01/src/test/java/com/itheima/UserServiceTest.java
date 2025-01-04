package com.itheima;

import org.junit.jupiter.api.Test;

/*
 * 测试类
 *
 * 小结：
 * 	1.JUnit单元测试是做什么的？
 * 		测试类中方法的正确性
 * 	2.JUnit单元测试的优点是什么？
 * 		测试代码与应用程序代码分开，便于维护
 * 		可以自动生成测试报告（通过：绿色，失败：红色）
 * 		一个测试方法执行失败，不会影响其他测试方法
 * 	3.JUnit单元测试的命名规范？
 * 		类：XxxxTest							（规范：只是建议，不是强制的）
 * 		方法：public void xxxx(){...}		 (规定：强制的，必需按照这个格式使用)
 */
public class UserServiceTest {
	@Test
	public void testGetAge() {
		UserService userService = new UserService();
		Integer age = userService.getAge("330109199906054110");// 身份证
		System.out.println(age);
	}
}
