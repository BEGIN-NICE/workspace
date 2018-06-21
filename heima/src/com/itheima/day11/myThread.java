package com.itheima.day11;

public class myThread extends Thread {

	
	
	public myThread() {
		super();
		// TODO Auto-generated constructor stub
	}

	public myThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println("myThread  "+Thread.currentThread().getName());
	}
	
}
