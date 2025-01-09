package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
 * 实体类：
 * 	用户信息
 *
 *
 * @Data    // 加上这个注解后，下面的属性会自动生成getter和setter方法
 * @NoArgsConstructor    // 加上这个注解后，会自动生成无参构造方法
 * @AllArgsConstructor    // 加上这个注解后，会自动生成有参构造方法
 */
public class User {
	private Integer id;    // 不用基本类型int，而使用包装类Integer；因为int类型有默认值0，而Integer类型没有默认值，为null
	private String username;
	private String password;
	private String name;
	private Integer age;
	private LocalDateTime updateTime;


	public User() {
	}

	public User(Integer id, String username, String password, String name, Integer age, LocalDateTime updateTime) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.age = age;
		this.updateTime = updateTime;
	}

	/**
	 * 获取
	 *
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置
	 *
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取
	 *
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置
	 *
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取
	 *
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置
	 *
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取
	 *
	 * @return age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * 设置
	 *
	 * @param age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * 获取
	 *
	 * @return updateTime
	 */
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置
	 *
	 * @param updateTime
	 */
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public String toString() {
		return "User{id = " + id + ", username = " + username + ", password = " + password + ", name = " + name + ", age = " + age + ", updateTime = " + updateTime + "}";
	}
}
