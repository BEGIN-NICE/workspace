package com.itheima.utils;

import javax.servlet.http.Cookie;

public class CookieUtil {
	public static Cookie findCookie(Cookie[] cookies ,String cookieName) {
		if(cookies == null) {
			return null;
		}else {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if(cookieName.equals(name)) {
					return cookie;
				}
			}
			return null;
		}
	}
}
