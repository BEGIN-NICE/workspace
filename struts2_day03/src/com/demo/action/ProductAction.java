package com.demo.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.DefaultInterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.codehaus.jackson.map.ObjectMapper;

import com.demo.domain.Product;
import com.demo.domain.Result;
import com.demo.service.ProductService;
import com.demo.service.impl.ProductServiceImpl;


@Namespace("/")
@ParentPackage("demo")
public class ProductAction {
	@Action(value="showproduct",interceptorRefs= @InterceptorRef("myStack"))
	public void execute() {
		try {
		ProductService productService = new ProductServiceImpl();
		List<Product> list = productService.findAll();
		Result<Product> result = new Result<>();
		result.setType(1);
		result.setList(list);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(result);
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().println(json);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
