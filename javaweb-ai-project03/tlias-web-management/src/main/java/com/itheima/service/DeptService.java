package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
	/**
	 * 查询所有部门
	 */
	List<Dept> findAll();

	/**
	 * 根据id删除部门
	 */
	void deleteById(Integer id);

	/**
	 * Step3：新增部门-接口层
	 */
	void add(Dept dept);

	/**
	 * 根据id查询部门信息
	 */
	Dept getInfoById(Integer id);

	/**
	 * 修改部门-接口层
	 */
	void update(Dept dept);
}
