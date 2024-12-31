package com.itheima;

/*
 * 什么是Maven？
 * 	- Maven是一款用于管理和构建Java项目的工具，是apache旗下的一个开源项目。
 *
 * 	Apache软件基金会，成立于1999年7月，是目前世界上最大的最受欢迎的开源软件基金会，也是一个专门为支持开源项目而生的非盈利组织。
 *
 * 	Apache Maven是一个项目管理和构建工具，它基于项目对象模型POM（project object model）的概念，通过一小段描述信息来管理项目的构建。
 * 	作用：
 * 		- 方便的依赖管理
 * 		- 标准的项目构建流程
 * 		- 统一的项目结构
 * 	官网：http://maven.apache.org/
 *
 *
 * 小结：
 * 	1.Maven的仓库是用来存储什么的？
 * 		- Maven的仓库是用来存储和管理jar包的
 *  2.Maven中有哪几类仓库？查找依赖（jar）的顺序是什么样的？
 * 		- 本地仓库（1）
 * 		- 远程仓库（2）
 * 		- 中央仓库（3）
 */
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello Maven");
	}
}
