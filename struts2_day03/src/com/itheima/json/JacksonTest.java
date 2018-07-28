package com.itheima.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.junit.Test;

import com.itheima.domain.Product;

public class JacksonTest {
	@Test
	public void Jackson_For_Object_Test() throws Exception {
		Product p = new Product();
		p.setId(1);
		p.setName("���ӻ�");
		p.setPrice(9999.9);
		p.setRelaceday(new Date());
		ObjectMapper mapper = new ObjectMapper();
		//�������ڸ�ʽ����
		mapper.setDateFormat(new SimpleDateFormat("yyyy/mm/dd"));
		String json = mapper.writeValueAsString(p);
		
		System.out.println(json);
	}
	
	@Test
	public void Jackson_For_Array_Test() throws Exception {
		Product p = new Product();
		p.setId(1);
		p.setName("���ӻ�");
		p.setPrice(9999.9);
		Product p2 = new Product();
		p2.setId(2);
		p2.setName("ϴ�»�");
		p2.setPrice(7899.9);
		List<Product> list = new ArrayList<>();
		list.add(p);
		list.add(p2);
		
		ObjectMapper mapper = new ObjectMapper();

//Ӳ����ķ�ʽ����ָ������		
//1�����������(������Щ����)
//		FilterProvider fp = new SimpleFilterProvider().addFilter("productFilter", 
//					SimpleBeanPropertyFilter.filterOutAllExcept("id","name"));
		
//2�����������(��������Щ����)
		FilterProvider fp = new SimpleFilterProvider().addFilter("productFilter", 	
				SimpleBeanPropertyFilter.serializeAllExcept("id","name"));
				
		mapper.setFilters(fp);
		
		String json = mapper.writeValueAsString(list);
		System.out.println(json);
	}
	
}
