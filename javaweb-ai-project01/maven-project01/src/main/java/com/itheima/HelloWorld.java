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


/*
 * Maven坐标：
 * 	什么是坐标？
 * 		- Maven中坐标是资源（jar）的唯一标识，通过该坐标可以唯一定位资源位置。
 * 		- 使用坐标来定义项目或引入项目中需要的依赖。
 *
 * 	Maven坐标组成：
 * 		- groupId：定义当前Maven项目隶属组织名称（通常是域名反写，例如：com.itheima）
 * 		- artifactId：定义当前Maven项目名称（通常是模块名称，例如 order-service、goods-service）
 * 		- version：定义当前项目版本号
 * 				- SNAPSHOT：功能不稳定、尚处于开发中的版本，即快照版本
 * 				- RELEASE：功能趋于稳定、当前更新停止，可以用于发行的版本
 *
 * 小结：
 * 	1.Maven的坐标由那几个部分组成？各部分的含义是什么？
 * 		groupId：组织名称
 * 		artifactId：模块名称
 * 		version：版本号
 * 	2.Maven项目的版本分类？
 * 		SNAPSHOT：功能不稳定、尚处于开发中的版本，即快照版本
 * 		RELEASE：功能趋于稳定、当前更新停止，可以用于发行的版本
 */

/*
 * 导入Maven项目：
 * 	- 建议将要导入的maven项目复制到你的项目目录下
 * 	- 建议选择maven项目的pom.xml文件进行导入
 */
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello Maven");
	}
}
