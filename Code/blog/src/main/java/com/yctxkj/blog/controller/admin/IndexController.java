/**
 * 
 */
package com.yctxkj.blog.controller.admin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.yctxkj.blog.interceptor.AdminInterceptor;
import com.yctxkj.blog.model.Admin;

/**
 * 后台
 * 
 * @author jiftle
 *
 */
@Before({SessionInViewInterceptor.class,AdminInterceptor.class})
public class IndexController extends Controller {

	//提供静态页面资源
	
	public void index(){
		Admin admin = this.getSessionAttr("loginAdmin");
		if(admin == null){
			this.redirect("/admin/login/index");
			return;
		}
		
		// 获取系统信息
		Properties systemPro = System.getProperties();
		HashMap hashtable = new LinkedHashMap<String,String>();
		
		String keys[] = new String[]{"os.name","os.version","os.arch","user.timezone","java.vendor","java.runtime.name","java.version","java.home","java.io.tmpdir","catalina.base"};
		for(int i=0;i<keys.length;i++){
			String key = keys[i];
			hashtable.put(key, systemPro.get(key));
		}
			
		
		setAttr("systemPro", hashtable);
				
		this.render("index.ftl");
	}
	
	public void tables(){
		this.render("tables.ftl");
	}
	
	public void typography(){
		this.render("typography.ftl");
	}
	
	public void forms(){
		this.render("forms.ftl");
	}
	
	public void charts(){
		this.render("charts.ftl");
	}
	
	@ActionKey("bootstrap-grid")
	public void bootstrap_grid(){
		this.render("bootstrap-grid.ftl");
	}
	
	@ActionKey("bootstrap-elements")
	public void bootstrap_elements(){
		this.render("bootstrap-elements.ftl");
	}
	
	@ActionKey("blank-page")
	public void blank_page(){
		this.render("blank-page.ftl");
	}
}
