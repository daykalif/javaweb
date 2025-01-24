package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpExpr;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpMapper empMapper;

	@Autowired
	private EmpExprMapper empExprMapper;

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
	public PageResult<Emp> pageHelperList(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
		// 1.设置分页参数（PageHelper）
		PageHelper.startPage(page, pageSize);

		// 2.执行查询
		List<Emp> empList = empMapper.pageHelperListMapper(name, gender, begin, end);    // 能用List接收是因为PageHelper插件会自动将查询结果封装成Page对象，而Page是ArrayList的子类，ArrayList实现了List接口；因此，List也可接收。
		// List<Emp> empList2 = empMapper.pageHelperListMapper();    // 注意事项：PageHelper仅仅能对紧跟在其后的第一个查询语句进行分页处理

		// 3.解析查询结果，并封装数据
		Page<Emp> p = (Page<Emp>) empList;
		Long total = p.getTotal();

		return new PageResult<Emp>(total, empList);
	}


	@Override
	public PageResult<Emp> pageQueryParam(EmpQueryParam empQueryParam) {
		//1. 设置分页参数(PageHelper)
		PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

		//2. 执行查询
		List<Emp> empList = empMapper.pageQueryParamMapper(empQueryParam);

		//3. 解析查询结果, 并封装
		Page<Emp> p = (Page<Emp>) empList;
		return new PageResult<Emp>(p.getTotal(), p.getResult());
	}


	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	public void save(Emp emp) {
		//	1.保存员工的基本信息
		emp.setCreateTime(LocalDateTime.now());
		emp.setUpdateTime(LocalDateTime.now());
		empMapper.insert(emp);

		//	2.保存员工工作经历信息
		List<EmpExpr> exprList = emp.getExprList();
		if (!CollectionUtils.isEmpty(exprList)) {
			// 遍历集合, 为empId赋值
			exprList.forEach(empExpr -> {
				/*
				 * emp.getId()：要想获取到刚刚插入的empId，需要对刚刚 empMapper.insert(emp) 的insert方法增加一个注解，@Options(useGeneratedKeys = true, keyProperty = "id")
				 * empExpr.setEmpId：获取到刚刚插入的empId，并赋值给empExpr表的emp_id属性
				 */
				empExpr.setEmpId(emp.getId());
			});
			empExprMapper.insertBatch(exprList);
		}
	}
}
