package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工工作经历Mapper
 */
@Mapper
public interface EmpExprMapper {
	/*
	 * 批量保存员工的工作经历信息
	 *
	 * sql语句记录在 "/src/main/resources/com/itheima/mapper/EmpExprMapper.xml" 中
	 */
	void insertBatch(List<EmpExpr> exprList);
}
