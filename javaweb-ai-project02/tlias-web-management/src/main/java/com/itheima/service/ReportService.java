package com.itheima.service;

import com.itheima.pojo.JobOption;

import java.util.List;
import java.util.Map;

/**
 * 图形报表业务层
 */
public interface ReportService {
	/**
	 * 统计员工职位人数
	 */
	JobOption getEmpJobData();
}
