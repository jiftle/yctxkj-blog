/**   
 * @Title: CacheController.java 
 * @Package com.yctxkj.blog.controller.admin 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author jiftle
 * @date 2017年2月20日 下午11:06:06
 * @version V1.0
 * @Copyright: 赢创天下科技有限公司
 *   
 */
package com.yctxkj.blog.controller.admin;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.ehcache.CacheKit;
import com.yctxkj.blog.interceptor.AdminInterceptor;

/** 
 * @ClassName: CacheController 
 * @Description: 缓存管理
 * @author jiftle
 * @date 2017年2月20日 下午11:06:06 
 * @Copyright: 赢创天下科技有限公司
 *  
 *  
 */
@Before({SessionInViewInterceptor.class,AdminInterceptor.class})
public class CacheController extends Controller {
	
	public void index(){
		this.render("cache/index.ftl");
	}
	
	/**
	 * 
	 * @Title: clear 
	 * @Description: 清理缓存 
	 * @param   参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	public void clear(){
		String type = this.getPara("type");
		Ret ret = new Ret();
		
		if("1".equals(type)){
			CacheKit.removeAll("blogIndex");
			
			ret.setOk();
			ret.set("msg", "清除首页缓存成功");
		}else{
			ret.setFail();
			ret.set("msg", "未定义的参数");
		}
		
		
		this.renderJson(ret);
	}
}
