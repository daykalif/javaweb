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

	@Test
	public void testDeleteById() {
		userMapper.deleteById(5);
	}

	@Test
	public void testDeleteById1() {
		Integer i = userMapper.deleteById1(4);
		System.out.println("执行完毕，影响的记录数：" + i);
	}

	@Test
	public void testInsert() {
		User user = new User(null, "admin", "123456", "管理员", 18);
		userMapper.insert(user);
	}

	@Test
	public void testUpdate() {
		User user = new User(1, "zhouyu", "666888", "周瑜", 20);
		userMapper.update(user);
	}

	@Test
	public void testFindByUsernameAndPassword() {
		User user = userMapper.findByUsernameAndPassword("zhouyu", "666888");
		System.out.println(user);
	}

	@Test
	public void testFindByUsernameAndPassword1() {
		User user = userMapper.findByUsernameAndPassword1("zhouyu", "666888");
		System.out.println(user);
	}
}
