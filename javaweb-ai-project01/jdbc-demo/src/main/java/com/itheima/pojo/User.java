package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data    // getter/setter/toString/hashCode/equals
@AllArgsConstructor    // 带参构造
@NoArgsConstructor    // 无参构造
public class User {
	private Integer id;
	private String username;
	private String password;
	private String name;
	private Integer age;
}
