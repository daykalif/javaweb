package com.itheima.springbootwebquickstart;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {
	/**
	 * 方式一：基于HttpServletResponse设置响应数据
	 *
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/response")
	public void response(HttpServletResponse response) throws IOException {
		//	1.设置响应状态码
		response.setStatus(HttpServletResponse.SC_OK);

		//	2.设置响应头
		response.setHeader("name", "daykalif");

		//	3.设置响应体
		response.getWriter().write("<h1>Hello Response</h1>");
	}

	/**
	 * 方式二：SpringBoot 中 ResponseEntity - Spring中提供的方式
	 *
	 * @return
	 */
	@RequestMapping("/response2")
	public ResponseEntity<String> response2() {
		return ResponseEntity.status(401)    //	响应状态码
				.header("name", "daykalif2")    //	响应头
				.body("<h1>Hello Response2</h1>");    //	响应体
	}
}
