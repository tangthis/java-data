/**
 * 
 */
package com.tngtech.thread;

/*
 * ThreadLocal实例
 * @author tngtech
 * @date 2015年12月29日
 *<p>博客:http://blog.csdn.net/jacman
 *<p>Github:https://github.com/tangthis
 *
 */
public class ThreadLocalDemo implements Runnable{
	ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			return 1;
		}
	};
	public void set(Integer i){
		local.set(i);
	}
	
	public Integer get(){
		return ((Integer)local.get()).intValue();
	}
	
	@Override
	public void run() {
		Integer i = get();
		for(int j = 0 ; j < 10; j ++){
			i = i + j;
		}
		set(i);
		
		
		System.out.println("变量值为：" + i);
	}
	
	public static void main(String[] args) {
		ThreadLocalDemo threadRunnable = new ThreadLocalDemo();
		Thread thread1 = new Thread(threadRunnable);
		Thread thread2 = new Thread(threadRunnable);
		thread1.start();
		
		//为了看到更明显的效果，线程睡眠1s
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		thread2.start();
		
		//打印结果
		//变量值为：46
		//变量值为：46
	}
	
}
