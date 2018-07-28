package com.itheima.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.itheima.domain.User;

public class FastjsonTest {
	@Test
	public void fastJSON_For_Object_Test1() {
		User user = new User(1, "tom", new Date());
		

		//���������Ƿ���json������
		SerializeFilter filter = new PropertyFilter() {
			
			@Override
			public boolean apply(Object arg0, String arg1, Object arg2) {
				//arg0 : Ҫת��json�Ķ���
				//arg1 : ��������
				//arg2 : ����ֵ
				
				if ("id".equals(arg1)) {
					return false;
				}
				return true;
			}
		};
		
		
		String json = JSONObject.toJSONString(user, filter);
		System.out.println(json);
	}
	
	@Test
	public void fastJSON_For_Array_Test1() {
		User user = new User(1, "tom", new Date());
		User user2 = new User(2, "tom2", new Date());
		User user3 = new User(3, "tom3", new Date());
		List<User> list = new ArrayList<>();
			list.add(user);
			//list.add(user2);
			//list.add(user3);
		
		//���������Ƿ���json������
		SerializeFilter filter = new PropertyFilter() {
			
			@Override
			public boolean apply(Object arg0, String arg1, Object arg2) {
				System.out.println(arg0);//arg0 : Ҫת��json�Ķ���
				System.out.println(arg1);//arg1 : ��������
				System.out.println(arg2);//arg2 : ����ֵ
				
				if ("id".equals(arg1)) {
					return false;
				}
				return true;
			}
		};
		
		
		String json = JSONArray.toJSONString(list,filter);
		System.out.println(json);
	}
}
