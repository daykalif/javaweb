package com.itheima;

import cn.hutool.core.io.FileUtil;
import com.itheima.utils.AliyunOSSThirdOperator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.nio.file.Files;

@SpringBootTest
public class SpringbootWebTests {
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private AliyunOSSThirdOperator aliyunOSSThirdOperator;

	@Test
	public void testScope() {
		for (int i = 0; i < 1000; i++) {
			Object deptController = applicationContext.getBean("deptController");
			System.out.println(deptController);
		}
	}

	@Test
	public void testAliyunOSSOperatorThird() throws Exception {
		File file = new File("/Users/daykalif/Desktop/web-project/javaweb-ai-project02/tlias-web-management/src/main/resources/static/原理篇/Bean管理/4.第三方bean.png");
		String url = aliyunOSSThirdOperator.uploadFile(FileUtil.readBytes(file), "4.第三方bean.png");
		System.out.println(url);
	}
}