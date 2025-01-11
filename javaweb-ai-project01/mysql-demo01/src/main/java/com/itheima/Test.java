package com.itheima;

/*
 * DDL关于数据库的操作小结：
 * 	1.同一个数据库服务器中，数据库的名字是否可以相同？
 * 		- 不可以
 * 	2.MySQL8版本默认的字符集是什么？
 * 		- utf8mb4
 * 		- default_charset utf8mb4
 *
 *
 * DDL关于数据类型小结：
 * 	1.数值类型在定义的时候，后面加了unsigned关键字是什么意思？
 * 		- unsigned表示无符号类型，表示只能取0及正数
 * 		- 不加默认是signed，表示可以取负数
 * 	2.char与varchar的区别是什么？什么时候用char，什么时候用varchar？
 * 		- char是定长字符串，varchar是变长字符串
 * 		- 如果一个字段的长度是固定的，建议使用char；如：身份证号、手机号
 * 		- 如果一个字段的长度不是固定的，建议使用varchar；如：用户名、姓名
 */
public class Test {
	/*
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
	 * -- ------------> DDL 表操作 <----------------
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
	 *
	 *
	 * -- ------------> 案例 <----------------
	 * -- 设计员工表 emp
	 * -- 基础字段：id 主键；create_time 创建时间；update_time 修改时间；
	 *
	 * create table emp
	 * (
	 *     id          int unsigned primary key auto_increment comment '主键',
	 *     username    varchar(20)      not null unique comment '用户名',
	 *     password    varchar(32) default '123456' comment '密码',
	 *     name        varchar(10)      not null comment '姓名',
	 *     gender      tinyint unsigned not null comment '性别, 1 男; 2 女',
	 *     phone       char(11)         not null unique comment '手机号',
	 *     job         tinyint unsigned comment '职位, 1 班主任; 2 讲师; 3 学工主管; 4 教研主管; 5 咨询师',
	 *     salary      int unsigned comment '薪资',
	 *     entry_date  date comment '入职日期',
	 *     image       varchar(255) comment '图像',
	 *     create_time datetime comment '创建时间',
	 *     update_time datetime comment '修改时间'
	 * ) comment '员工表';
	 *
	 *
	 * -- 查询当前数据库所有表
	 * show tables;
	 *
	 * -- 查看表结构
	 * desc emp;
	 *
	 * -- 查询建表语句
	 * show create table emp;
	 *
	 * -- 字段：添加字段 qq varchar(13)
	 * alter table emp
	 *     add column qq varchar(13) comment 'QQ号码';
	 *
	 * -- 字段：修改字段类型 qq varchar(15)
	 * alter table emp
	 *     modify column qq varchar(15) comment 'QQ号码';
	 *
	 * -- 字段：修改字段名 qq -> qq_num varchar(15)
	 * alter table emp
	 *     change column qq qq_num varchar(15) comment 'QQ号码';
	 *
	 * -- 字段：删除字段 qq_num
	 * alter table emp
	 *     drop column qq_num;
	 *
	 * -- 修改表名
	 * alter table emp
	 *     rename to employee;
	 *
	 * -- 删除表
	 * drop table employee;
	 *
	 *
	 *
	 * -- ------------> DML 表数据操作 <----------------
	 * -- DML : 数据操作语言
	 *
	 * -- DML : 插入数据 - insert
	 * -- 1. 为 emp 表的 username, password, name, gender, phone 字段插入值
	 * insert into emp(username, password, name, gender, phone)
	 * values ('admin', '123456', '管理员', 1, '13888888888');
	 *
	 *
	 * -- 2. 为 emp 表的 所有字段插入值
	 * -- 方式1:
	 * insert into emp(id, username, password, name, gender, phone, job, salary, entry_date, image, create_time, update_time)
	 * values (null, 'root', '12345678', 'root', 1, '13788889999', 1, 6000, '2020-01-01',
	 *         'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1911272957,1476945884&fm=26&gp=0.', now(), now());
	 * -- 方式2:
	 * insert into emp
	 * values (null, 'wjp', '123456789', 'root', 1, '13733334444', 1, 6000, '2020-01-01',
	 *         'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1911272957,1476945884&fm=26&gp=0.', now(), now());
	 *
	 *
	 * -- 3. 批量为 emp 表的 username, password, name, gender, phone  字段插入数据
	 * insert into emp(username, password, name, gender, phone)
	 * values ('lisi', '123456', '李四', 1, '13133338887'),
	 *        ('wangwu', '123456', '王五', 1, '13133338888'),
	 *        ('zhaoliu', '123456', '赵六', 1, '13133338889');
	 *
	 *
	 * -- DML : 更新数据 - update
	 * -- 1. 将 emp 表的ID为1员工 用户名更新为 'zhangsan', 姓名name字段更新为 '张三'
	 * update emp
	 * set username = 'zhangsan',
	 *     name     = '张三'
	 * where id = 1;
	 *
	 *
	 * -- 2. 将 emp 表的所有员工的入职日期更新为 '2010-01-01'
	 * update emp
	 * set entry_date = '2010-01-01';
	 *
	 *
	 * -- DML : 删除数据 - delete
	 * -- 1. 删除 emp 表中 ID为1的员工
	 * delete
	 * from emp
	 * where id = 1;
	 *
	 * -- 2. 删除 emp 表中的所有员工
	 * delete
	 * from emp;
	 */
}
