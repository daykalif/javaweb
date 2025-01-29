package com.itheima;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest    // 可以使用 Spring Boot 提供的测试注解（如 @SpringBootTest）来启动整个 Spring 应用程序上下文，测试多个组件之间的交互和协作，确保系统在集成环境下的正确性。
class TliasWebManagementApplicationTests {

	@Autowired    // 依赖注入的注解；应用程序运行时，会自动的查询该类型的bean对象，并赋值给该成员变量
	private DeptMapper deptMapper;        //	多态的使用方式

	/*
	 * 切片测试：Spring Boot 提供了多种切片测试注解（如 @WebMvcTest、@DataJpaTest 等），用于只加载应用程序的部分组件进行测试，从而提高测试的执行效率。
	 * 例如，@WebMvcTest 可以只加载 Spring MVC 相关的组件，用于测试控制器层的功能。
	 */
	@Test
	public void testFindAll() {
		List<Dept> deptList = deptMapper.findAll();
		deptList.forEach(System.out::println);
	}
}
