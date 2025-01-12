package com.itheima;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTest {
	/**
	 * JDBC入门程序
	 */
	@Test
	public void testUpdate() throws Exception {
		// 1.注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");

		//	2.获取数据库连接
		String url = "jdbc:mysql://localhost:3306/web01";
		String username = "root";
		String password = "xxxx";
		Connection connection = DriverManager.getConnection(url, username, password);

		//	3.获取SQL-DML语句执行对象
		Statement statement = connection.createStatement();

		//	4.执行SQL
		String sql = "update user set age = 25 where id = 1";
		int i = statement.executeUpdate(sql);// 执行DML语句时，可调用executeUpdate
		System.out.println("SQL执行完毕影响的记录数为：" + i);

		//	5.释放资源
		statement.close();
		connection.close();
	}
}
