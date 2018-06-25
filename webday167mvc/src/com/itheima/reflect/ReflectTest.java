package com.itheima.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectTest {
	/**
	 * ��ô����������ص��ڴ���ֽ����ļ��Ķ���
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
	 * ͨ�������ù��췽������������
	 * @throws Exception
	 */
	@Test
	public void getConstructorByClass() throws Exception {
		Class clazz = Class.forName("com.itheima.reflect.Person");
		//�����޲�����������
		Person person1 = (Person) clazz.newInstance();
		person1.run();
		//�����в����Ĺ��췽��������������
		Constructor constructor = clazz.getConstructor(String.class,Integer.class);
		Person person2 = (Person) constructor.newInstance("fanxh",22);
		System.out.println(person2.getAge());
		System.out.println(person2.getName());
	}
	
	/**
	 * ͨ������������
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
	 * ͨ�����������еķ���
	 * @throws Exception
	 */
	@Test
	public void getMethodByClass() throws Exception {
		Class clazz = Class.forName("com.itheima.reflect.Person");
		//����޲����ķ��������÷���ִ��
		Method method = clazz.getDeclaredMethod("run");
		method.setAccessible(true);
		method.invoke(clazz.newInstance());
		//����в����ķ��������÷���ִ��
		Method method2 = clazz.getDeclaredMethod("sayHello", String.class);
		method2.setAccessible(true);
		String s = (String) method2.invoke(clazz.newInstance(), "fanС");
		System.out.println(s);
	}
}
