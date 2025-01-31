package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class SpringbootWebTests {
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void testScope() {
		for (int i = 0; i < 1000; i++) {
			Object deptController = applicationContext.getBean("deptController");
			System.out.println(deptController);
		}
	}
}
