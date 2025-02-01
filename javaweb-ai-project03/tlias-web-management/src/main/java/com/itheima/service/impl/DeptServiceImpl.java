package com.itheima.service.impl;

import com.itheima.anno.LogOperation;
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
@Service    // 声明为Spring IOC容器的bean
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptMapper deptMapper;

	@LogOperation    // 切入点表达式@Annotation在使用时需要根据注解@LogOperation来定位需要执行的方法；表示当前方法需要记录日志，用于AOP代理
	@Override
	public List<Dept> findAll() {
		return deptMapper.findAll();
	}

	@LogOperation
	@Override
	public void deleteById(Integer id) {
		deptMapper.deleteById(id);
	}

	/**
	 * Step4: 新增部门-实现类
	 */
	@LogOperation
	@Override
	public void add(Dept dept) {
		//	a.补全基础属性 - createTime, updateTime
		dept.setCreateTime(LocalDateTime.now());
		dept.setUpdateTime(LocalDateTime.now());

		//	b.调用Mapper接口方法插入数据
		deptMapper.add(dept);
	}

	@Override
	public Dept getInfoById(Integer id) {
		return deptMapper.getMapperById(id);
	}

	/**
	 * 修改部门-实现类
	 */
	@LogOperation
	@Override
	public void update(Dept dept) {
		//	补全基础属性 - updateTime
		dept.setUpdateTime(LocalDateTime.now());

		//	调用Mapper接口方法更新数据
		deptMapper.update(dept);
	}
}
