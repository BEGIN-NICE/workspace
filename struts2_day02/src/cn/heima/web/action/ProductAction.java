package cn.heima.web.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.heima.domain.Product;

public class ProductAction extends ActionSupport {

	public String list() {
		ArrayList<Product> list = new ArrayList<>();
		Product p1 = new Product();
		p1.setName("µç±ùÏä");
		p1.setPrice(1234);
		p1.setCount(100);
		Product p2 = new Product();
		p2.setName("Ï´ÒÂ»ú");
		p2.setPrice(3214);
		p2.setCount(55);
		list.add(p1);
		list.add(p2);
		ActionContext.getContext().getValueStack().set("ps", list);
		return "success";
	}
	
	public String show() {
		ArrayList<Product> list = new ArrayList<>();
		Product p1 = new Product();
		p1.setName("µç±ùÏä");
		p1.setPrice(1234);
		p1.setCount(100);
		Product p2 = new Product();
		p2.setName("Ï´ÒÂ»ú");
		p2.setPrice(3214);
		p2.setCount(55);
		list.add(p1);
		list.add(p2);
		ActionContext.getContext().getValueStack().set("ps", list);
		return "success";
	}
}
