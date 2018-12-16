/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.yctxkj.blog.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 
 * @ClassName: WebUtils 
 * @Description: web工具
 * @author jiftle
 * @date 2017年2月9日 上午12:00:26 
 * @Copyright: 赢创天下科技有限公司
 *  
 *
 */
public final class WebUtils {

	public static String getCookie(HttpServletRequest request, String key){
		Cookie cookies[]=request.getCookies();
		 if(cookies!=null){
		     for(int i=0;i<cookies.length;i++){
		    	  if(key.equals(cookies[i].getName())) return cookies[i].getValue();
		     }
		 }
		 return null;
	}
	
	public static void setCookie(HttpServletResponse response, String key, String value){
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(3600*24*365*30);//cookies保存时间30年
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String key){
		Cookie cookies[]=request.getCookies();
		 if(cookies!=null){
		     for(int i=0;i<cookies.length;i++){
		    	  if(key.equals(cookies[i].getName())){
		    		  cookies[i].setMaxAge(0);
		    		  response.addCookie(cookies[i]);
		    	  }
		     }
		 }
	}

}