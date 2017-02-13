package com.yctxkj.blog.interceptor;



import org.apache.log4j.Logger;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * BlogInterceptor
 * 此拦截器仅做为示例展示，在本 demo 中并不需要
 */
public class ExecuteTimeInterceptor implements Interceptor {
	
	private static final Logger logger = Logger.getLogger(ExecuteTimeInterceptor.class);
	
	public void intercept(Invocation inv) {
		Long executeTime ;
		Long startTime = System.currentTimeMillis();
		
		inv.invoke();
		
		Long endTime = System.currentTimeMillis();
		executeTime = endTime - startTime;
		
		if (logger.isDebugEnabled()) {
			logger.debug("[" + inv.getActionKey() + "] executeTime: " + executeTime + "ms");
		}
		
	
	}
}
