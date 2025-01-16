package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper    // 表示该接口是一个MyBatis的持久层接口，用于操作数据库；应用程序在运行时，会自动的为该接口创建一个实现类对象（代理对象），并且会自动将该实现类对象存入IOC容器 - bean。
public interface DeptMapper {
	/*
	 * 查询所有部门
	 */
	// 选中括号中的内容，右键>"Show Context Actions">"inject language or reference">MySql
	@Select("select id, name, create_time, update_time from dept order by update_time desc;")
	public List<Dept> findAll();
}
