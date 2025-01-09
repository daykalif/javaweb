package com.itheima.test;

/*
 * 1.Http协议中请求数据分为哪几个部分？
 * 	- 请求行（请求数据的第一行）
 * 	- 请求头（key:value）
 * 	- 请求体（与请求头之间隔了一个空行）
 *
 * 2.HTTP响应数据分为几个部分？
 * 	- 响应行、响应头、响应体
 *
 * 3.响应状态码的分类？
 * 	- 1xx：响应中，临时状态码
 *  - 2xx：成功
 *  - 3xx：重定向
 *  - 4xx：客户端错误
 *  - 5xx：服务端错误
 *
 * 4.HTTP响应数据需要程序员自己动手设置吗？
 * 	- 不需要
 *  - Web服务器对HTTP响应数据进行了封装（HTTPServletResponse）
 *
 * 5.响应状态码、响应头需要我们手动指定吗？
 * 	- 通常情况下，我们无需手动制定、服务器会根据请求逻辑自动设置
 */
public class HTTP {
}
