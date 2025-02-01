package com.itheima;

import java.io.*;
import java.nio.file.Files;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.OSSObjectSummary;

public class OssJavaSdkQuickStart {
	public static void main(String[] args) throws com.aliyuncs.exceptions.ClientException {
		// 验证环境变量是否可用
		String accessKeyId = System.getenv("OSS_ACCESS_KEY_ID");
		String accessKeySecret = System.getenv("OSS_ACCESS_KEY_SECRET");
		System.out.println("OSS_ACCESS_KEY_ID: " + accessKeyId);
		System.out.println("OSS_ACCESS_KEY_SECRET: " + accessKeySecret);


		// 设置 OSS Endpoint 和 Bucket 名称
		String endpoint = "https://oss-cn-beijing.aliyuncs.com";
		String bucketName = "daykalif-java-ai2";
		// 替换为您的 Bucket 区域
		String region = "cn-beijing";
		// 创建 OSSClient 实例
		EnvironmentVariableCredentialsProvider credentialsProvider =
				CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

		OSS ossClient = OSSClientBuilder.create()
				.endpoint(endpoint)
				.credentialsProvider(credentialsProvider)
				.region(region)
				.build();
		try {
			// 1. 创建存储空间（Bucket）
			ossClient.createBucket(bucketName);
			System.out.println("1. Bucket " + bucketName + " 创建成功。");
			// 2. 上传文件
			String objectName = "1.UI.png";
			String filePath = "/Users/daykalif/Desktop/web-project/javaweb-ai-project02/tlias-web-management/src/main/resources/static/员工管理/文件上传/1.UI.png";
			File file = new File(filePath);
			byte[] content = Files.readAllBytes(file.toPath());
			ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content));
			System.out.println("2. 文件 " + objectName + " 上传成功。");
			// 3. 下载文件
			OSSObject ossObject = ossClient.getObject(bucketName, objectName);
			InputStream contentStream = ossObject.getObjectContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(contentStream));
			String line;
			System.out.println("3. 下载的文件内容：");
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			contentStream.close();
			// 4. 列出文件
			System.out.println("4. 列出 Bucket 中的文件：");
			ObjectListing objectListing = ossClient.listObjects(bucketName);
			for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
				System.out.println(" - " + objectSummary.getKey() + " (大小 = " + objectSummary.getSize() + ")");
			}
			/*
			 * // 5. 删除文件
			 * ossClient.deleteObject(bucketName, objectName);
			 * System.out.println("5. 文件 " + objectName + " 删除成功。");
			 *
			 * // 6. 删除存储空间（Bucket）
			 * ossClient.deleteBucket(bucketName);
			 * System.out.println("6. Bucket " + bucketName + " 删除成功。");
			 */
		} catch (OSSException oe) {
			System.out.println("Caught an OSSException, which means your request made it to OSS, "
					+ "but was rejected with an error response for some reason.");
			System.out.println("Error Message:" + oe.getErrorMessage());
			System.out.println("Error Code:" + oe.getErrorCode());
			System.out.println("Request ID:" + oe.getRequestId());
			System.out.println("Host ID:" + oe.getHostId());
		} catch (ClientException | IOException ce) {
			System.out.println("Caught an ClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with OSS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message:" + ce.getMessage());
		} finally {
			if (ossClient != null) {
				ossClient.shutdown();
			}
		}
	}
}