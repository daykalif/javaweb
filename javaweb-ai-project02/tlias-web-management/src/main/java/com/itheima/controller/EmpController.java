package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工管理controller
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
	@Autowired
	private EmpService empService;

	/**
	 * 分页查询-原始方式
	 */
	@GetMapping
	public Result list(@RequestParam(defaultValue = "1") Integer page,
					   @RequestParam(defaultValue = "10") Integer pageSize) {
		log.info("分页查询员工信息，当前页码：{}，每页记录数：{}", page, pageSize);
		PageResult<Emp> pageResult = empService.page(page, pageSize);
		return Result.success(pageResult);
	}


	/**
	 * 分页查询-PageHelper插件
	 */
	@GetMapping("/page-helper")
	public Result pageHelperList(@RequestParam(defaultValue = "1") Integer page,
								 @RequestParam(defaultValue = "20") Integer pageSize) {
		log.info("PageHelper---->>>分页查询员工信息，当前页码：{}，每页记录数：{}", page, pageSize);
		PageResult<Emp> pageResult = empService.pageHelperList(page, pageSize);
		return Result.success(pageResult);
	}
}
