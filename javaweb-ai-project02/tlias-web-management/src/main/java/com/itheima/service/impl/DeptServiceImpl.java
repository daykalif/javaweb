package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
 * 实现类
 *
 * 声明bean的注解有哪几个？（注意：是加在实现类上，而非接口上）
 * 		- @Controller
 * 		- @Service
 * 		- @Repository
 * 		- @Component
 */
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public List<Dept> findAll() {
		return deptMapper.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		deptMapper.deleteById(id);
	}

	/**
	 * Step4: 新增部门-实现类
	 */
	@Override
	public void add(Dept dept) {
		//	a.补全基础属性 - createTime, updateTime
		dept.setCreateTime(LocalDateTime.now());
		dept.setUpdateTime(LocalDateTime.now());

		//	b.调用Mapper接口方法插入数据
		deptMapper.add(dept);
	}
}
