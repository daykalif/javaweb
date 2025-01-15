package com.itheima.controller;

import org.springframework.web.bind.annotation.RestController;

/*
 * @RestController用于标识当前类是spring控制层的类，也就是一个请求处理类；
 *
 * @RestController = @Controller + @ResponseBody
 *
 * @Controller：将控制层的类也交给IOC容器管理
 * @ResponseBody：标识当前方法的返回值，直接作为响应体返回给浏览器；如果返回值是一个对象，则默认转换为json格式返回；
 */
@RestController
public class DeptController {
}
