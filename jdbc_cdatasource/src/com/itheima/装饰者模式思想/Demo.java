package com.itheima.װ����ģʽ˼��;

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
		System.out.println("����");
	}
	
}

class WaitressWrapper implements Waiter{
	private Waiter waiter;
	public WaitressWrapper(Waiter waiter) {
		this.waiter = waiter;
	}
	
	@Override
	public void server() {
		System.out.println("΢Ц");
		waiter.server();
	}
	
}