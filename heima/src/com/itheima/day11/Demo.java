package com.itheima.day11;

import org.junit.Test;

public class Demo {
	/**
	 * ���Ի�ȡ�߳�����
	 */
	@Test
	public void threadGetName() {
		myThread myThread = new myThread();
		myRunnable myRunnable = new myRunnable();

		Thread thread = new Thread(myRunnable);
		thread.start();
		myThread.start();
	}
}
