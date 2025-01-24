package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工信息Mapper
 */
@Mapper
public interface EmpMapper {
	/**
	 * 查询总记录数
	 */
	@Select("select count(*) from emp left join dept on emp.dept_id = dept.id")
	public Long count();

	/**
	 * 分页查询-原始方式
	 */
	@Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc limit #{start}, #{pageSize}")
	public List<Emp> list(Integer start, Integer pageSize);


	/**
	 * 分页查询-PageHelper
	 */
	@Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")	// 注意事项：定义的SQL语句结尾不能加分号；
	public List<Emp> pageHelperList();
}
