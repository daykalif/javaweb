package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpMapper empMapper;

	/*
	 * 分页查询-原始方式
	 */
	@Override
	public PageResult<Emp> page(Integer page, Integer pageSize) {
		// 1.调用mapper接口，查询总记录数
		Long total = empMapper.count();

		// 2.调用mapper接口，查询结果列表
		Integer start = (page - 1) * pageSize;
		List<Emp> rows = empMapper.list(start, pageSize);

		// 3.封装结果 PageResult
		return new PageResult<Emp>(total, rows);
	}


	/*
	 * 分页查询-使用MyBatis-Plus：PageHelper插件
	 *
	 * 注意事项：
	 * 		1.定义的SQL语句结尾不能加分号；
	 * 		2.PageHelper仅仅能对紧跟在其后的第一个查询语句进行分页处理
	 */
	@Override
	public PageResult<Emp> pageHelperList(Integer page, Integer pageSize) {
		// 1.设置分页参数（PageHelper）
		PageHelper.startPage(page, pageSize);

		// 2.执行查询
		List<Emp> empList = empMapper.pageHelperList();    // 能用List接收是因为PageHelper插件会自动将查询结果封装成Page对象，而Page是ArrayList的子类，ArrayList实现了List接口；因此，List也可接收。
		List<Emp> empList2 = empMapper.pageHelperList();	// 注意事项：PageHelper仅仅能对紧跟在其后的第一个查询语句进行分页处理

		// 3.解析查询结果，并封装数据
		Page<Emp> p = (Page<Emp>) empList;
		Long total = p.getTotal();

		return new PageResult<Emp>(total, empList);
	}
}
