package com.itheima.utils;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.common.comm.SignVersion;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * 假设这是第三方提供的类，我们无法用@Component注解
 */
public class AliyunOSSThirdOperator {
	private final AliyunOSSProperties aliyunOSSProperties;

	public AliyunOSSThirdOperator(AliyunOSSProperties aliyunOSSProperties) {
		this.aliyunOSSProperties = aliyunOSSProperties;
	}

	public String uploadFile(byte[] content, String originalFilename) throws Exception {
		String endpoint = aliyunOSSProperties.getEndpoint();
		String bucketName = aliyunOSSProperties.getBucketName();
		String region = aliyunOSSProperties.getRegion();
		EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
		String dir = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM"));
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		String objectName = dir + "/" + newFileName;

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
