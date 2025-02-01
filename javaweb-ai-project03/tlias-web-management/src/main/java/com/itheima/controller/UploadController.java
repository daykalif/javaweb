package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class UploadController {
	/*
	 * 本地磁盘存储方案
	 *
	 * springboot默认最大上传文件大小为1MB，可通过配置文件修改
	 */
	//@PostMapping("/upload")
	//public Result upload(String name, Integer age, MultipartFile file) throws IOException {
	//	log.info("接收参数: {},{},{}", name, age, file);
	//
	//	//获取原始文件名
	//	String originalFilename = file.getOriginalFilename();
	//
	//	//新的文件名
	//	String extension = originalFilename.substring(originalFilename.lastIndexOf("."));    // 获取文件后缀名
	//	String newFileName = UUID.randomUUID().toString() + extension;    // 生成新的文件名（uuid + 文件后缀名）
	//
	//	//保存文件
	//	file.transferTo(new File("/Users/daykalif/Desktop/web-project/javaweb-ai-project02/tlias-web-management/CustomLog/images/" + newFileName));
	//	return Result.success();
	//}


	/*
	 * 阿里云OSS存储方案
	 */
	@Autowired
	private AliyunOSSOperator aliyunOSSOperator;

	@PostMapping("/upload")
	public Result upload(MultipartFile file) throws Exception {
		log.info("文件上传: {}", file.getOriginalFilename());

		//将文件交给OSS存储管理
		String url = aliyunOSSOperator.uploadFile(file.getBytes(), file.getOriginalFilename());
		log.info("文件上传OSS, url: {}", url);

		return Result.success(url);
	}
}