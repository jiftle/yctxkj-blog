package com.yctxkj.blog.interceptor;

import org.apache.log4j.Logger;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.yctxkj.blog.model.Log;
import com.yctxkj.blog.util.DateUtils;
import com.yctxkj.blog.util.HttpUtils;

/**
 * 
 * @ClassName: LogInterceptor 
 * @Description: 访问日志拦截器
 * @author jiftle
 * @date 2017年2月18日 下午12:52:14 
 * @Copyright: 赢创天下科技有限公司
 *  
 *
 */
public class LogInterceptor implements Interceptor {
	
	private static final Logger logger = Logger.getLogger(LogInterceptor.class);
	
	public void intercept(Invocation inv) {
		
		String actionKey = inv.getActionKey();
		String ip = HttpUtils.getRemoteAddr(inv.getController().getRequest());
		String ipregion = "";//HttpUtils.getIpAddressInfo(ip);
		
		if(actionKey.startsWith("/admin/")){
			
			Log log = new Log();
			
			log.set("create_date", DateUtils.getCurDateTime());
			log.set("modify_date",DateUtils.getCurDateTime());
			log.set("ip",ip);
			log.set("ipregion",ipregion);
			log.set("logtype","login");
			log.set("operation", "访问");
			log.set("level", "-1");
			log.set("url", inv.getActionKey());
			
			log.save();
			
		}else{
			Log log = new Log();
			
			log.set("create_date", DateUtils.getCurDateTime());
			log.set("modify_date",DateUtils.getCurDateTime());
			log.set("ip",ip);
			log.set("ipregion",ipregion);
			log.set("logtype","access");
			log.set("operation", "访问");
			log.set("level", "-1");
			log.set("url", inv.getActionKey());
			
			log.save();
		}
		
		inv.invoke();
		
		
	
	}
}
