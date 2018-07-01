package com.itheima.demo1;

@Anno1("value")
@Anno2(a = 0, b = false, s = "aa" , e=Color.red , a1=@Anno1("value"))
@Anno3("value")
public class AnnotationDemo1 {

}



/**
 * 定义一个注解
 */
@interface Anno1{
	String value();
}

/**
 * 定义一个带有属性的注解
 * @author fanxh
 *
 */
@interface Anno2{
	/*注解中定义属性，要带小括号
	 * 属性的类型：基本，String,Class,注解类型，枚举类型，以上类型的一维数组
	 */
	int a();
	boolean b() default false;//属性默认值
	String s();
	Color e() default Color.red;
	Anno1 a1();
}

enum Color{
	red,blue,green
}

@interface Anno3{
	String value();
}
