package com.itheima.day11;

public class myRunnable implements Runnable {

	
	@Override
	public void run() {
		System.out.println("myRunnable   "+Thread.currentThread().getName());
	}

}
