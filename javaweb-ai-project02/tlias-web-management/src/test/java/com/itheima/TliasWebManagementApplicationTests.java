package com.itheima;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TliasWebManagementApplicationTests {

	@Autowired    // 依赖注入的注解；应用程序运行时，会自动的查询该类型的bean对象，并赋值给该成员变量
	private DeptMapper deptMapper;        //	多态的使用方式

	@Test
	public void testFindAll() {
		List<Dept> deptList = deptMapper.findAll();
		deptList.forEach(System.out::println);
	}
}
