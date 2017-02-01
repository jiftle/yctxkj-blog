/**
 * 
 */
package com.yctxkj.blog.controller.admin;

import com.jfinal.core.Controller;

/**
 * 后台
 * 
 * @author jiftle
 *
 */
public class IndexController extends Controller {

	//提供静态页面资源
	public void index(){
		this.render("index.ftl");
	}
	
	public void tables(){
		this.render("tables.ftl");
	}
	
}
