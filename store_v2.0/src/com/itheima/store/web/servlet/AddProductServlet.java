package com.itheima.store.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.itheima.store.domain.Category;
import com.itheima.store.domain.Product;
import com.itheima.store.service.ProductService;
import com.itheima.store.service.impl.ProductServiceImpl;
import com.itheima.store.utils.BeanFactory;
import com.itheima.store.utils.UUIDUtil;


/**
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * �ļ��ϴ���servlet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
			//1��ô����ļ����
				DiskFileItemFactory factory = new DiskFileItemFactory();
				//���û�������С
				factory.setSizeThreshold(3*1024*1024);//3��
				//������ʱ�ļ����·��
				//factory.setRepository(repository);
			//2��ú��Ľ�����ServletFileUpload
				ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
				//��������ļ����ϴ�����
				servletFileUpload.setHeaderEncoding("utf-8");
				//servletFileUpload.setFileSizeMax(fileSizeMax);//���ñ��е����ļ���С
				//servletFileUpload.setSizeMax(sizeMax);//���ñ��������ļ�����ܴ�С
				
			//3����request������list����
				
			List<FileItem> parseRequest = servletFileUpload.parseRequest(request);
			Map<String, String> map = new HashMap<>();
			String fileName=null;
			for (FileItem fileItem : parseRequest) {
				if(fileItem.isFormField()) {
					String name = fileItem.getFieldName();
					String value = fileItem.getString("UTF-8");//�����ͨ����������
					System.out.println(name+"====="+value);
					map.put(name, value);
				}else{
					fileName = fileItem.getName();
					System.out.println(fileName);
					String realPath = this.getServletContext().getRealPath("/products/1");
					InputStream inputStream = fileItem.getInputStream();
					OutputStream outputStream = new FileOutputStream(realPath+"/"+fileName);
					int len;
					byte[] buf = new byte[1024];
					while((len=inputStream.read(buf))!=-1) {
						outputStream.write(buf, 0, len);
					}
					outputStream.close();
					inputStream.close();
				}
			}
			Category category = new Category();
			category.setCid(map.get("cid"));
			Product product = new Product();
			BeanUtils.populate(product, map);
			product.setPdate(new Date());
			product.setPid(UUIDUtil.getUUID());
			product.setPimage("products/1/"+fileName);
			product.setPflag(0);
			product.setCategory(category);
			ProductService productService = (ProductServiceImpl)BeanFactory.getBean("productServiceImpl");
			productService.save(product);
			response.sendRedirect(request.getContextPath()+"/AdminProductServlet?method=findAllByPage&currPage=1");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
