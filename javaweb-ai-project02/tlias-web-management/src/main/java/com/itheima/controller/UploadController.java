package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

	/**
	 * 本地磁盘存储方案
	 *
	 * springboot默认最大上传文件大小为1MB，可通过配置文件修改
	 */
	@PostMapping("/upload")
	public Result upload(String name, Integer age, MultipartFile file) throws IOException {
		log.info("接收参数: {},{},{}", name, age, file);

		//获取原始文件名
		String originalFilename = file.getOriginalFilename();

		//新的文件名
		String extension = originalFilename.substring(originalFilename.lastIndexOf("."));	// 获取文件后缀名
		String newFileName = UUID.randomUUID().toString() + extension;	// 生成新的文件名（uuid + 文件后缀名）

		//保存文件
		file.transferTo(new File("/Users/daykalif/Desktop/web-project/javaweb-ai-project02/tlias-web-management/CustomLog/images/" + newFileName));
		return Result.success();
	}
}
