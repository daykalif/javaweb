package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper    // 表示该接口是一个MyBatis的持久层接口，用于操作数据库；应用程序在运行时，会自动的为该接口创建一个实现类对象（代理对象），并且会自动将该实现类对象存入IOC容器 - bean。
public interface DeptMapper {
	/*
	 * 查询所有部门
	 */

	/*
	 * 方式一：手动结果映射
	 *
	 * @Results({
	 *        @Result(column = "create_time", property = "createTime"),
	 *        @Result(column = "update_time", property = "updateTime")
	 * })
	 */

	/*
	 * 方式二：起别名
	 *
	 * @Select("select id, name, create_time createTime, update_time updateTime from dept order by update_time desc;")
	 */

	// 选中括号中的内容，右键>"Show Context Actions">"inject language or reference">MySql
	@Select("select id, name, create_time, update_time from dept order by update_time desc;")
	public List<Dept> findAll();

	//===============================================================================================================

	/**
	 * 根据id删除部门
	 */
	@Delete("delete from dept where id = #{id} ")
	// 预编译接口，#{id} 会变成 ?
	void deleteById(Integer id);

	//===============================================================================================================

	/*
	 * Step5:新增部门-持久层接口
	 *
	 * 数据库的列名是下划线命名，属性名是驼峰命名，所有此处values中传递的应该是传递进来的Dept的属性名
	 * MyBatis会自动将参数名与数据库列名进行映射，所以可以不用写列名
	 */
	@Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
	void add(Dept dept);
}
