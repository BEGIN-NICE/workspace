package com.itheima.test;

public class Demo1 {
	private static int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static void main(String[] args) {
		Demo1 demo1 = new Demo1();
		demo1.age=10;
		System.out.println(age);
	}
}
