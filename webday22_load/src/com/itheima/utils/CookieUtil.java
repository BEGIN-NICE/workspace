package com.itheima.utils;

import javax.servlet.http.Cookie;

public class CookieUtil {
	//根据名称查找指定Cookie
	public static Cookie getCookie(Cookie[] cookies,String cookieName) {
		if(cookies==null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if(cookieName.equals(cookie.getName())) {
				return cookie;
			}
		}
		return null;
	}
}
