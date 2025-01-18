package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @RestController用于标识当前类是spring控制层的类，也就是一个请求处理类；
 *
 * @RestController = @Controller + @ResponseBody
 *
 * @Controller：将控制层的类也交给IOC容器管理
 * @ResponseBody：标识当前方法的返回值，直接作为响应体返回给浏览器；如果返回值是一个对象，则默认转换为json格式返回；
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
	/*
	 * 如果类名上增加了注解@Slf4j，则会自动生成一个日志对象，可以直接使用；如果不加，则需要手动创建一个日志对象，代码如下：
	 * private static final Logger logger = LoggerFactory.getLogger(DeptController.class);
	 */

	@Autowired        // Controller层需要调用Service层，则依赖注入service；应用程序运行时，会自动的查询该类型的bean对象，并赋值给该成员变量
	private DeptService deptService;

	/*
	 * 查询全部部门
	 */
	@GetMapping    //	@RequestMapping(value = "/depts", method = RequestMethod.GET)
	public Result list() {
		log.info("查询全部部门");    //System.out.println("查询全部部门");
		List<Dept> deptList = deptService.findAll();
		return Result.success(deptList);
	}

	// =================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================

	/*
	 * 删除部门 - 方式一：HttpServletRequest 获取请求参数
	 */
	//@DeleteMapping
	//public Result delete(HttpServletRequest request) {
	//	String idStr = request.getParameter("id");
	//	int id = Integer.parseInt(idStr);
	//	System.out.println("根据Id删除部门：" + id);
	//	return Result.success();
	//}


	/*
	 * 删除部门 - 方式二：@RequestParam注解
	 *
	 * 注意事项：一旦声明@RequestParam注解，则请求参数中必须包含该参数名，否则会报错；
	 * 			(@RequestParam注解内部声明了：boolean required() default true;)
	 *
	 * 如果希望该参数不是必须的，则需要设置required属性为false：
	 * 		public Result delete(@RequestParam(value = "id", required = false) Integer deptId)
	 */
	//@DeleteMapping
	//public Result delete(@RequestParam("id") Integer deptId) {
	//	System.out.println("根据Id删除部门-->" + deptId);
	//	return Result.success();
	//}


	/*
	 * 删除部门 - 方式三：如果请求参数名与形参变量名相同，直接定义方法形参即可接收。（省略@RequestParam）
	 */
	@DeleteMapping
	public Result delete(Integer id) {
		log.info("根据Id删除部门===>{}", id);    // System.out.println("根据Id删除部门===>" + id);
		deptService.deleteById(id);
		return Result.success();
	}

	// =================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================

	/**
	 * Step1:新增部门
	 */
	@PostMapping
	public Result add(@RequestBody Dept dept) {
		log.info("新增部门--->{}", dept);    // System.out.println("新增部门：" + dept);
		// Step2:调用Service层新增部门
		deptService.add(dept);
		return Result.success();
	}

	// =================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================

	/*
	 * 根据Id查询部门
	 */
	//@GetMapping("/{id}")
	//public Result getInfo(@PathVariable("id") Integer deptId) {
	//	System.out.println("根据Id查询部门：" + deptId);
	//	return Result.success();
	//}


	@GetMapping("/{id}")
	public Result getInfo(@PathVariable Integer id) {
		log.info("根据Id查询部门***>{}", id);    // System.out.println("根据Id查询部门：" + id);
		Dept dept = deptService.getInfoById(id);
		return Result.success(dept);
	}

	// =================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================

	/**
	 * 修改部门
	 */
	@PutMapping
	public Result update(@RequestBody Dept dept) {
		log.info("修改部门###>{}", dept);    // System.out.println("修改部门：" + dept);
		deptService.update(dept);
		return Result.success();
	}
}
