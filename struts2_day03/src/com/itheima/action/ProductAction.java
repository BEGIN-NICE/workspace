package com.itheima.action;

import java.util.ArrayList;
import java.util.List;

import com.itheima.domain.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
public class ProductAction extends ActionSupport {

	public String getProduct() {
		Product p = new Product();
		p.setId(1);
		p.setName("电视机");
		p.setPrice(9999.9);
		Product p2 = new Product();
		p2.setId(2);
		p2.setName("洗衣机");
		p2.setPrice(7899.9);
		List<Product> list = new ArrayList<>();
		list.add(p);
		list.add(p2);
		
		ActionContext.getContext().getValueStack().set("list", list);
		
		return "success";
	}
}
