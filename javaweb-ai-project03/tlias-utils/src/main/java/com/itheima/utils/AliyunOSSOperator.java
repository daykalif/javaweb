package com.itheima.utils;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.common.comm.SignVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class AliyunOSSOperator {
	// 方式一：直接指定参数
	//private String endpoint = "https://oss-cn-beijing.aliyuncs.com";
	//private String bucketName = "daykalif-java-ai2";
	//private String region = "cn-beijing";

	// 方式二：从配置文件application.yml中获取相关参数，一个属性一个属性的注入
	//@Value("${aliyun.oss.endpoint}")
	//private String endpoint;
	//@Value("${aliyun.oss.bucketName}")
	//private String bucketName;
	//@Value("${aliyun.oss.region}")
	//private String region;

	// 方式三：从配置类AliyunOSSProperties.java中获取相关参数，完成批量注入
	@Autowired
	private AliyunOSSProperties aliyunOSSProperties;

	public String uploadFile(byte[] content, String originalFilename) throws Exception {
		// 验证环境变量是否可用
		String accessKeyId = System.getenv("OSS_ACCESS_KEY_ID");
		String accessKeySecret = System.getenv("OSS_ACCESS_KEY_SECRET");
		System.out.println("OSS_ACCESS_KEY_ID------->" + accessKeyId);
		System.out.println("OSS_ACCESS_KEY_SECRET------->" + accessKeySecret);

		String endpoint = aliyunOSSProperties.getEndpoint();
		String bucketName = aliyunOSSProperties.getBucketName();
		String region = aliyunOSSProperties.getRegion();

		// 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
		EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

		// 填写Object完整路径，例如2024/06/1.png。Object完整路径中不能包含Bucket名称。
		//获取当前系统日期的字符串,格式为 yyyy/MM
		String dir = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM"));
		//生成一个新的不重复的文件名
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		String objectName = dir + "/" + newFileName;

		// 创建OSSClient实例。
		ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
		clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
		OSS ossClient = OSSClientBuilder.create()
				.endpoint(endpoint)
				.credentialsProvider(credentialsProvider)
				.clientConfiguration(clientBuilderConfiguration)
				.region(region)
				.build();

		try {
			ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content));
		} finally {
			ossClient.shutdown();
		}

		return endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + objectName;
	}

}
