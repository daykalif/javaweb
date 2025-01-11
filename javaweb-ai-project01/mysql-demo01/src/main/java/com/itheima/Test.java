package com.itheima;

/*
 * DDL关于数据库的操作小结：
 * 	1.同一个数据库服务器中，数据库的名字是否可以相同？
 * 		- 不可以
 * 	2.MySQL8版本默认的字符集是什么？
 * 		- utf8mb4
 * 		- default_charset utf8mb4
 */
public class Test {
/**
 *-- 查询数据库
 * show databases;
 *
 * -- 创建数据库
 * create database db01;
 *
 * -- 切换数据库
 * use db01;
 *
 * -- 查询当前正在使用的数据库
 * select database();
 *
 * -- 删除数据库
 * drop database db01;
 *
 * -- ------------> DDL 表操作----------------
 * -- 创建表
 * create table user
 * (
 *     id       int comment 'ID，唯一标识',
 *     username varchar(50) comment '用户名',
 *     name     varchar(10) comment '姓名',
 *     age      int comment '年龄',
 *     gender   char(1) comment '性别'
 * ) comment '用户信息表';
 *
 *
 * -- 创建表（约束）
 * create table user
 * (
 *     id       int primary key auto_increment comment 'ID，唯一标识', -- 主键约束 auto_increment
 *     username varchar(50) not null unique comment '用户名',         -- 非空，唯一
 *     name     varchar(10) not null comment '姓名',                  -- 非空
 *     age      int comment '年龄',
 *     gender   char(1) default '男' comment '性别'                   -- 默认
 * ) comment '用户信息表';
 */
}
