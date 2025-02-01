package com.itheima;

import com.example.HeaderGenerator;
import com.example.HeaderParser;
import com.example.TokenParser;
import com.google.gson.Gson;
import com.itheima.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GsonTest {
	@Autowired
	private Gson gson;    // SpringBoot自动配置

	@Test
	public void testJson() {
		System.out.println(gson.toJson(Result.success("Hello Gson")));
	}


	@Autowired
	private TokenParser tokenParser;

	@Test
	public void testTokenParser() {
		tokenParser.parse();
	}

	@Autowired
	private HeaderParser headerParser;

	@Test
	public void testHeaderParser() {
		headerParser.parse();
	}

	@Autowired
	private HeaderGenerator headerGenerator;

	@Test
	public void testHeaderGenerator() {
		headerGenerator.generate();
	}
}
