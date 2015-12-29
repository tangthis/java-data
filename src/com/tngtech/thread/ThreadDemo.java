/**
 * 
 */
package com.tngtech.thread;

/*
 * 
 * @author tngtech
 * @date 2015年12月29日
 *<p>博客:http://blog.csdn.net/jacman
 *<p>Github:https://github.com/tangthis
 *
 */
public class ThreadDemo implements Runnable{
	
	private Integer i = 1;

	@Override
	public void run() {
		for(int j = 0 ; j < 10 ; j++){
			i = i + j;
		}
		System.out.println("变量值为：" + i);
	}

	
	public static void main(String[] args) {
		ThreadDemo threadDemoRunnable = new ThreadDemo();
		Thread thread1 = new Thread(threadDemoRunnable);
		Thread thread2 = new Thread(threadDemoRunnable);
		thread1.start();
		
		//为了看到更明显的效果，线程睡眠1s，再启动另外一个线程
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		thread2.start();
		//打印结果
		//变量值为：46
		//变量值为：91
	}
}
