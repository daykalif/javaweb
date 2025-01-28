package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.JobOption;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private EmpMapper empMapper;


	/*
	 * 统计员工职位人数
	 *
	 * list是一个Map类型的List，list的数据为：[{pos=学工主管, num=1}, {pos=其他, num=2}, {pos=咨询师, num=7}, {pos=班主任, num=9}, {pos=讲师, num=14}]
	 * 一个map为：{pos=学工主管, num=1}
	 * 		map的其中一个key为：pos，value为：学工主管
	 * 		map的其中一个key为：num，value为：1
	 * 因此定义map的类型时，定义为：Map<String, Object>	，因为map的key是String类型的，但是value类型是动态的，所以定义为Object类型
	 */
	@Override
	public JobOption getEmpJobData() {
		//1. 调用mapper接口, 获取统计数据
		List<Map<String, Object>> list = empMapper.countEmpJobData();
		System.out.println("list=====>" + list);    // [{pos=学工主管, num=1}, {pos=其他, num=2}, {pos=咨询师, num=7}, {pos=班主任, num=9}, {pos=讲师, num=14}]

		//2. 组装结果, 并返回
		List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
		List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

		return new JobOption(jobList, dataList);
	}
}
