package com.yctxkj.blog.interceptor;



import org.apache.log4j.Logger;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * 
 * @ClassName: ExecuteTimeInterceptor 
 * @Description: 执行时间
 * @author jiftle
 * @date 2017年2月18日 下午12:51:56 
 * @Copyright: 赢创天下科技有限公司
 *  
 *
 */
public class ExecuteTimeInterceptor implements Interceptor {
	
	private static final Logger logger = Logger.getLogger(ExecuteTimeInterceptor.class);
	
	public void intercept(Invocation inv) {
		Long executeTime ;
		Long startTime = System.currentTimeMillis();
		
		inv.invoke();
		
		Long endTime = System.currentTimeMillis();
		executeTime = endTime - startTime;
		
//		if (logger.isDebugEnabled()) {
			logger.info("[" + inv.getActionKey() + "] executeTime: " + executeTime + "ms");
//		}
		
	
	}
}
