package com.itheima;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类
 */
public class UserGenderService2Test {
	private UserService userService;

	@BeforeEach
	public void setUp() {
		userService = new UserService();
	}

	//	-------------------------测试获取性别-------------------------------

	/**
	 * 测试性别获取 - null
	 */
	@Test
	@DisplayName("性别获取 - null")
	public void testGetGender1() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			userService.getGender(null);
		});
	}

	/**
	 * 测试获取性别 - ""
	 */
	@Test
	@DisplayName("获取性别 - 空串")
	public void testGetGender2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			userService.getGender("");
		});
	}


	/**
	 * 测试获取性别 - 长度不足
	 */
	@Test
	@DisplayName("获取性别 - 长度不足")
	public void testGetGender3() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			userService.getGender("110");
		});
	}


	/**
	 * 测试获取性别 - 长度超出
	 */
	@Test
	@DisplayName("获取性别 - 长度超出")
	public void testGetGender4() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			userService.getGender("11001110020020011000110010110001");
		});
	}


	/**
	 * 测试获取性别 - 正常：男
	 */
	@Test
	@DisplayName("获取性别 - 正常男性身份证")
	public void testGetGender5() {
		String gender = userService.getGender("330109199906054110");
		Assertions.assertEquals("男", gender);
	}


	/**
	 * 测试获取性别 - 正常：女
	 */
	@Test
	@DisplayName("获取性别 - 正常女性身份证")
	public void testGetGender6() {
		String gender = userService.getGender("330109199906054100");
		Assertions.assertEquals("女", gender);
	}

//	-------------------------测试获取年龄-------------------------------

	/**
	 * 测试获取年龄 - 正常
	 */
	@Test
	@DisplayName("获取年龄 - 正常身份证")
	public void testGetAge1() {
		Integer age = userService.getAge("330109199906054100");
		Assertions.assertEquals(25, age);
	}


	/**
	 * 测试获取年龄 - null
	 */
	@Test
	@DisplayName("获取年龄 - null值")
	public void testGetAge2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			userService.getAge(null);
		});
	}

	/**
	 * 测试获取年龄 - 超长
	 */
	@Test
	@DisplayName("获取年龄 - 长度超长")
	public void testGetAge3() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			userService.getAge("11001110020020011000110010110001");
		});
	}

	/**
	 * 测试获取年龄 - 超长
	 */
	@Test
	@DisplayName("获取年龄 - 长度不足")
	public void testGetAge4() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			userService.getAge("110");
		});
	}

}
