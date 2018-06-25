package com.itheima.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectTest {
	/**
	 * 获得代表这个类加载到内存的字节码文件的对象。
	 * @return 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void getClassObject() throws ClassNotFoundException {
		Class clazz = Person.class;
		Person person = new Person();
		Class clazz1 = person.getClass();
		Class class2 = Class.forName("com.itheima.reflect.Person");
	}
	
	/**
	 * 通过反射获得构造方法，创建对象
	 * @throws Exception
	 */
	@Test
	public void getConstructorByClass() throws Exception {
		Class clazz = Class.forName("com.itheima.reflect.Person");
		//根据无参数创建对象
		Person person1 = (Person) clazz.newInstance();
		person1.run();
		//采用有参数的构造方法论来创建对象
		Constructor constructor = clazz.getConstructor(String.class,Integer.class);
		Person person2 = (Person) constructor.newInstance("fanxh",22);
		System.out.println(person2.getAge());
		System.out.println(person2.getName());
	}
	
	/**
	 * 通过反射获得属性
	 * @throws Exception
	 */
	@Test
	public void getFiledByClass() throws Exception {
		Class clazz = Class.forName("com.itheima.reflect.Person");
		Field field = clazz.getDeclaredField("name");
		Constructor constructor = clazz.getDeclaredConstructor(String.class,Integer.class);
		Person person = (Person)constructor.newInstance("fanxh",22);
		field.setAccessible(true);
		String name = (String)field.get(person);
		System.out.println(name);
	}
	
	/**
	 * 通过反射获得类中的方法
	 * @throws Exception
	 */
	@Test
	public void getMethodByClass() throws Exception {
		Class clazz = Class.forName("com.itheima.reflect.Person");
		//获得无参数的方法，并让方法执行
		Method method = clazz.getDeclaredMethod("run");
		method.setAccessible(true);
		method.invoke(clazz.newInstance());
		//获得有参数的方法，并让方法执行
		Method method2 = clazz.getDeclaredMethod("sayHello", String.class);
		method2.setAccessible(true);
		String s = (String) method2.invoke(clazz.newInstance(), "fan小");
		System.out.println(s);
	}
}
