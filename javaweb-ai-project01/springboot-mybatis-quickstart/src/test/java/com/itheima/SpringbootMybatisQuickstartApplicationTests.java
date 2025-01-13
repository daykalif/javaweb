package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest    // SpringBoot单元测试的注解 - 当前测试类中的测试方法运行时，会启动整个SpringBoot项目，同时会创建IOC容器，可以在测试类中注入所需要的bean
class SpringbootMybatisQuickstartApplicationTests {
	@Autowired    // 依赖注入的注解
	private UserMapper userMapper;

	@Test
	public void testFindAll() {
		List<User> userList = userMapper.findAll();
		userList.forEach(System.out::println);
	}
}
