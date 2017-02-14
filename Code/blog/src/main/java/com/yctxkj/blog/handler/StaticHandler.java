/**   
 * @Title: StaticHandler.java 
 * @Package com.yctxkj.blog.handler 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author jiftle
 * @date 2017年2月14日 下午10:52:02
 * @version V1.0
 * @Copyright: 赢创天下科技有限公司
 *   
 */
package com.yctxkj.blog.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.jfinal.handler.Handler;
import com.yctxkj.blog.interceptor.ExecuteTimeInterceptor;

/** 
 * @ClassName: StaticHandler 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author jiftle
 * @date 2017年2月14日 下午10:52:02 
 * @Copyright: 赢创天下科技有限公司
 *  
 *  
 */
public class StaticHandler extends Handler {

	//日志
	private static final Logger logger = Logger.getLogger(StaticHandler.class);
	
	public final String[] dirs;
	
	public StaticHandler(String... dirs){
		this.dirs = dirs;
	}
	
	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		
		//是否需要排除
		boolean needExclude = false;
		for(String dir: dirs){
			if(target.startsWith(dir)){
				needExclude = true;
				break;
			}
		}
		if(needExclude){
			logger.info("----- static handler ----- " + target);
			return;
		}
		
		next.handle(target, request, response, isHandled);
	}

}
