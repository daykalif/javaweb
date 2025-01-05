package com.itheima;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * 参数化测试
 *
 * 小结：
 * 	1.JUnit单元测试的方法，是否可以声明方法形参？
 * 		- 可以的，参数化测试
 * 		- @ParameterizedTest + @ValueSource
 *
 * 	2.如何实现在单元测试方法运行之前，做一些初始化操作？
 * 		- @BeforeEach、@BeforeAll
 *
 * 	3.如何实现在单元测试方法运行之后，释放对应的资源？
 * 		- @AfterEach、@AfterAll
 */
@DisplayName("用户信息的测试类")
public class UserGenderServiceTest {
	@BeforeAll    // 在所有的单元测试方法运行之前，运行一次
	public static void beforeAll() {
		System.out.println("before all");
	}

	@AfterAll    //	在所有的单元测试方法运行之后，运行一次
	public static void afterAll() {
		System.out.println("after all");
	}

	@BeforeEach    // 在每一个单元测试方法运行之前，都会运行一次
	public void beforeEach() {
		System.out.println("before each");
	}

	@AfterEach    // 在每一个单元测试方法运行之后，都会运行一次
	public void afterEach() {
		System.out.println("after each");
	}

	@DisplayName("测试用户性别")
	@ParameterizedTest
	@ValueSource(strings = {"330109199906054110", "330109199906054130", "330109199906054150"})
	public void testGetGender2(String idCard) {
		UserService userService = new UserService();
		String gender = userService.getGender(idCard);
		// 断言
		Assertions.assertEquals("男", gender);
	}
}
