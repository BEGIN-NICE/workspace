package com.itheima.装饰者模式思想;

public class Demo {
	public static void main(String[] args) {
		Waiter wrapper = new WaitressWrapper(new Waitress());
		wrapper.server();
	}
	
}

interface Waiter{
	void server();
}
class Waitress implements Waiter{

	@Override
	public void server() {
		System.out.println("服务");
	}
	
}

class WaitressWrapper implements Waiter{
	private Waiter waiter;
	public WaitressWrapper(Waiter waiter) {
		this.waiter = waiter;
	}
	
	@Override
	public void server() {
		System.out.println("微笑");
		waiter.server();
	}
	
}