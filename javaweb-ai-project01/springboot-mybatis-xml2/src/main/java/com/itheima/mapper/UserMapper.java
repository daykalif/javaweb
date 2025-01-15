package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper    // 表示该接口是一个MyBatis的持久层接口，用于操作数据库；应用程序在运行时，会自动的为该接口创建一个实现类对象（代理对象），并且会自动将该实现类对象存入IOC容器 - bean。
public interface UserMapper {
	// 基于xml配置查询所有用户
	public List<User> findAll();    // 安装Mybatis插件后，findAll方法会报红，此处是因为出现多个同包同名的方法，需要手动解决。
}
