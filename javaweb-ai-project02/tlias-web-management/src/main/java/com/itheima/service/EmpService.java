package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public interface EmpService {
	/**
	 * 分页查询-原始方法
	 */
	PageResult<Emp> page(Integer page, Integer pageSize);

	/**
	 * 分页查询-mybatis-plus：PageHelper插件
	 */
	PageResult<Emp> pageHelperList(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);

	/**
	 * 分页查询-条件查询
	 */
	PageResult<Emp> pageQueryParam(EmpQueryParam empQueryParam);

	/**
	 * 新增员工信息
	 */
	void save(Emp emp) throws Exception;
}
