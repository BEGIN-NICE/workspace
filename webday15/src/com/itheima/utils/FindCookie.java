package com.itheima.utils;

import javax.servlet.http.Cookie;

public class FindCookie {
	public static Cookie getCookie(Cookie[] cookie,String cookieName) {
		if(cookie == null) {
			return null;
		}else {
			for (Cookie cookie2 : cookie) {
				if(cookieName.equals(cookie2.getName())) {
					return cookie2;
				}
			}
			return null;
		}
	}
}
