package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
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


	/*
	 * 分页查询-PageHelper
	 *
	 * select查询语句
	 * 	方式一：@Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
	 * 	方式二：使用mapper.xml文件，在mapper.xml文件中定义SQL语句，再通过SQLSession对象执行SQL语句；
	 */

	// 注意事项：定义的SQL语句结尾不能加分号；
	public List<Emp> pageHelperListMapper(String name, Integer gender, LocalDate begin, LocalDate end);


	/**
	 * 请求参数优化
	 */
	public List<Emp> pageQueryParamMapper(EmpQueryParam empQueryParam);

	//-------------------------------------------------------------------------------------------------------------------

	/**
	 * 新增员工基本信息
	 */
	@Options(useGeneratedKeys = true, keyProperty = "id") //获取到生成的主键 -- Mybatis提供的功能：主键返回
	@Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
			" values (#{username}, #{name}, #{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
	void insert(Emp emp);

	//-------------------------------------------------------------------------------------------------------------------

	/**
	 * 根据id批量删除员工信息
	 *
	 * 这里的ids是动态的，动态sql需要在xml映射文件中配置
	 */
	void deleteByIds(List<Integer> ids);
}
