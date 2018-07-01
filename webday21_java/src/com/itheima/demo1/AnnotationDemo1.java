package com.itheima.demo1;

@Anno1("value")
@Anno2(a = 0, b = false, s = "aa" , e=Color.red , a1=@Anno1("value"))
@Anno3("value")
public class AnnotationDemo1 {

}



/**
 * ����һ��ע��
 */
@interface Anno1{
	String value();
}

/**
 * ����һ���������Ե�ע��
 * @author fanxh
 *
 */
@interface Anno2{
	/*ע���ж������ԣ�Ҫ��С����
	 * ���Ե����ͣ�������String,Class,ע�����ͣ�ö�����ͣ��������͵�һά����
	 */
	int a();
	boolean b() default false;//����Ĭ��ֵ
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
