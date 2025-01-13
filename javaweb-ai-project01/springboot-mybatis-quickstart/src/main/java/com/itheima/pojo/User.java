package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 实体类：用户信息
 */
@Data    // 加上这个注解后，下面的属性会自动生成getter和setter方法
@AllArgsConstructor    // 加上这个注解后，会自动生成无参构造方法
@NoArgsConstructor    // 加上这个注解后，会自动生成有参构造方法
public class User {
	private Integer id;    // 不用基本类型int，而使用包装类Integer；因为int类型有默认值0，而Integer类型没有默认值，为null
	private String username;
	private String password;
	private String name;
	private Integer age;
}