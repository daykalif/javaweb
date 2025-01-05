package com.itheima;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceAiTest {

	private UserService userService;

	@BeforeEach
	public void setUp() {
		userService = new UserService();
	}

	@Test
	public void getGender_NullInput_ThrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> userService.getGender(null));
	}

	@Test
	public void getGender_InvalidLength_ThrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> userService.getGender("12345678901234567"));
	}

	@Test
	public void getGender_ValidMaleIdCard_ReturnsMale() {
		assertEquals("男", userService.getGender("11010519491231002X"));
	}

	@Test
	public void getGender_ValidFemaleIdCard_ReturnsFemale() {
		assertEquals("女", userService.getGender("110105194912310021"));
	}
}
