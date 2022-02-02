package it.exolab.utils;

import javax.servlet.http.HttpSession;

public class Flash {
	public static Object flash(HttpSession session, String key) {
		Object ret =  session.getAttribute(key);
		session.removeAttribute(key);
		return ret;
	}
	
	public static Object flash(HttpSession session, String key,Object value) {
		session.setAttribute(key,value);
		return null;
	}
}
