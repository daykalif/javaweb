package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;

public interface EmpService {
	PageResult<Emp> page(Integer page, Integer pageSize);

	PageResult<Emp> pageHelperList(Integer page, Integer pageSize);
}
