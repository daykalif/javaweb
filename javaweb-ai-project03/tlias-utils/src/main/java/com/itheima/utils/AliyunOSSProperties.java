package com.itheima.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data   // 添加getter/setter方法
@Component  // 将当前类标记为组件, 让Spring IOC管理
@ConfigurationProperties(prefix = "aliyun.oss") // 将配置文件application.yml中的aliyun.oss.*前缀的属性值注入到当前类中
public class AliyunOSSProperties {
    private String endpoint;
    private String bucketName;
    private String region;
}
