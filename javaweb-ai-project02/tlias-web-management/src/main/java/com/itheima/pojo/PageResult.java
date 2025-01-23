package com.itheima.pojo;

import lombok.Data;

import java.util.List;

/**
 * 分页结果封装类
 */
@Data
public class PageResult<T> {
	private Long total;
	private List<T> rows;
}
