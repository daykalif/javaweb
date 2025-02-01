package com.itheima;

public class ThreadLocalTest {

	private static ThreadLocal<String> local = new ThreadLocal<>();

	public static void main(String[] args) {
		local.set("Main Message");

		//创建子线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				local.set("Sub Message");
				System.out.println("子线程：" + Thread.currentThread().getName() + " : " + local.get());
			}
		}).start();

		System.out.println("主线程：" + Thread.currentThread().getName() + " : " + local.get());

		// 删除
		local.remove();

		System.out.println("主线程：" + Thread.currentThread().getName() + " : " + local.get());
	}
}
