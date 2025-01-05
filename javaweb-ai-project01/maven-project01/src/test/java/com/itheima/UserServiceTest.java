package com.itheima;

import org.junit.jupiter.api.Assertions;
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
 *
 * 思考：
 * 	1.单元测试运行不报错（绿色），就代表代码没问题，测试通过？
 * 		- 并不是
 *
 * 小结：
 * 	1.在JUnit单元测试中，为什么要使用断言？
 * 		- 单元测试方法运行不报错，不代表业务方法没问题。
 * 		- 通过断言可以检测方法运行结果是否和预期一致，从而判断业务方法的正确性。
 * 		- Assertion.assertXxxx(...)
 */
public class UserServiceTest {
	@Test
	public void testGetAge() {
		UserService userService = new UserService();
		Integer age = userService.getAge("330109199906054110");// 身份证
		System.out.println(age);
	}

	@Test
	public void testGetGender() {
		UserService userService = new UserService();
		String gender = userService.getGender("330109199906054110");
		System.out.println(gender);
	}

	/**
	 * 断言正常情况
	 */
	@Test
	public void testGenderWithAssert() {
		UserService userService = new UserService();
		String gender = userService.getGender("330109199906054110");
		Assertions.assertEquals("男", gender);
		Assertions.assertEquals("女", gender, "性别实际值与期望不符");
	}

	/**
	 * 断言异常情况
	 */
	@Test
	public void testGenderWithAssert2() {
		UserService userService = new UserService();
		String gender = userService.getGender("330109199906054110");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			userService.getGender(null);
		});

		Assertions.assertThrows(NullPointerException.class, () -> {
			userService.getGender(null);
		});
	}
}
