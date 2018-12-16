/**
 * 
 */
package com.yctxkj.blog.controller.admin;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.yctxkj.blog.interceptor.AdminInterceptor;
import com.yctxkj.blog.model.Log;

/**
 * 
 * @ClassName: LogController 
 * @Description: 操作日志
 * @author jiftle
 * @date 2017年2月18日 下午12:31:47 
 * @Copyright: 赢创天下科技有限公司
 *  
 *
 */
@Before({SessionInViewInterceptor.class,AdminInterceptor.class})
public class LogController extends Controller {

	public void login_list(){
		String sql = "select * from xx_log where logtype='login' order by id desc;";
		List<Log> logList = Log.dao.find(sql);
		
		this.setAttr("logList", logList);
		
		this.render("log/login_list.ftl");
	}
	
	public void access_list(){
		String sql = "select * from xx_log where logtype='access' order by id desc;";
		List<Log> logList = Log.dao.find(sql);
		
		this.setAttr("logList", logList);
		
		this.render("log/access_list.ftl");
	}
	
	public void access_list_del(){
		String id = this.getPara("id");
		boolean bRet = Log.dao.deleteById(id);
	
		this.redirect("/admin/log/access_list");
	}
	
	public void login_list_del(){
		String id = this.getPara("id");
		boolean bRet = Log.dao.deleteById(id);
	
		this.redirect("/admin/log/login_list");
	}
	
}
