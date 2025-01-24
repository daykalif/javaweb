package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

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
	@GetMapping("/origin")
	public Result list(@RequestParam(defaultValue = "1") Integer page,
					   @RequestParam(defaultValue = "10") Integer pageSize
	) {
		log.info("分页查询员工信息，当前页码：{}，每页记录数：{}", page, pageSize);
		PageResult<Emp> pageResult = empService.page(page, pageSize);
		return Result.success(pageResult);
	}


	/**
	 * 分页查询-PageHelper插件
	 */
	@GetMapping
	public Result pageHelperList(@RequestParam(defaultValue = "1") Integer page,
								 @RequestParam(defaultValue = "20") Integer pageSize,
								 String name,
								 Integer gender,
								 @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
								 @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
	) {
		log.info("PageHelper---->>>分页查询员工信息，当前页码：{}，每页记录数：{}", page, pageSize);
		log.info("分页查询员工姓名：{}，员工性别：{}，入职日期：{} - {}", name, gender, begin, end);

		PageResult<Emp> pageResult = empService.pageHelperList(page, pageSize, name, gender, begin, end);
		return Result.success(pageResult);
	}
}
