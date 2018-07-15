package com.itheima.store.web.servlet;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.store.domain.Image;
import com.itheima.store.domain.PageBean;
import com.itheima.store.domain.Product;
import com.itheima.store.service.ProductService;
import com.itheima.store.service.impl.ProductServiceImpl;
import com.itheima.store.utils.BeanFactory;
import com.itheima.store.utils.CookieUtil;

import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ������Ʒ������в�ѯ�����ҷ�ҳ��ʾ
	 * @param request
	 * @param response
	 * @return
	 */
	public String findByCid(HttpServletRequest request,HttpServletResponse response) {
		try {
			String cid = request.getParameter("cid");
			Integer currPage = Integer.parseInt(request.getParameter("currPage"));
			ProductService productService = (ProductServiceImpl)BeanFactory.getBean("productServiceImpl");
			PageBean pageBean = productService.findByCid(cid,currPage);
			request.setAttribute("pageBean", pageBean);
			return "/store/product_list.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	
	/**
	 * �����Ʒ��������ƷID��ѯ��Ʒ������Ϣ 
	 * @param request
	 * @param response
	 * @return
	 */
	public String findByPid(HttpServletRequest request,HttpServletResponse response) {
		try {
			String pid = request.getParameter("pid");		
			ProductService productService = (ProductServiceImpl)BeanFactory.getBean("productServiceImpl");
			Product product = productService.findByPid(pid);
			
			//��Ʒ�����¼ ,"history"
			Cookie[] cookies = request.getCookies();
			Cookie cookie = CookieUtil.getCookie(cookies, "history");
			LinkedList<String> linkedList ;
			if(cookie == null) {
				cookie = new Cookie("history",pid);
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(7*24*60*60);
				response.addCookie(cookie);
				String[] ids = cookie.getValue().split("-");
				linkedList = new LinkedList<String>(Arrays.asList(ids));
			}else {
				
				String[] ids = cookie.getValue().split("-");
				linkedList = new LinkedList<String>(Arrays.asList(ids));
				linkedList.remove(pid);
				linkedList.addFirst(pid);
				if(linkedList.size() > 6) {
					linkedList.removeLast();
				}
				
				StringBuffer sb = new StringBuffer();
				for (String id : linkedList) {
					sb.append(id).append("-");
				}
				String substring = sb.toString().substring(0,sb.length()-1);
				cookie = new Cookie("history",substring);
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(7*24*60*60);
				response.addCookie(cookie);
			}
			request.getSession().setAttribute("history", linkedList);
			System.out.println(product.getPdesc());
			request.setAttribute("product", product);
			return "/store/product_info.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/**
	 * ͼƬ˫������
	 * @param request
	 * @param response
	 * @return
	 */
	public String fileDownLoad(HttpServletRequest request,HttpServletResponse response) {
		try {
			String pid = request.getParameter("pid");
			ProductService productService = (ProductServiceImpl)BeanFactory.getBean("productServiceImpl");
			Product product = productService.findByPid(pid);
			Image image = productService.findImageByPid(pid);
			String filename = image.getFilename();
			String pimage = product.getPimage();
			String realPath = this.getServletContext().getRealPath(pimage);
			InputStream inputStream = new FileInputStream(realPath);
			String type = this.getServletContext().getMimeType(filename);
			response.setHeader("Context-Type", type);
			
			// ��������������Ͳ��ò�ͬ���룬IE��Chrome���õ���URL���룬FireFox���õ���BASE64���롣
			String agent = request.getHeader("User-Agent");
			if (agent.contains("FireFox")) {
				filename = base64EncodeFileName(filename);
			} else {
				filename = URLEncoder.encode(filename, "utf-8");
			}
			// ����Content-Dispositionͷ ,�����filename��Ҫ����
			response.setHeader("Content-Disposition", "attachment;filename=" + filename);
			
			ServletOutputStream outputStream = response.getOutputStream();
			int len;
			byte[] buf = new byte[1024];
			while((len = inputStream.read(buf))!= -1) {
				outputStream.write(buf, 0, len);
			}
			inputStream.close();
			
			
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/**
	 * ����������BASE64����
	 * 
	 * @param fileName
	 * @return
	 */
	public static String base64EncodeFileName(String fileName) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
			return "=?UTF-8?B?" + new String(base64Encoder.encode(fileName.getBytes("UTF-8"))) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
