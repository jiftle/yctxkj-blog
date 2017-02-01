/**
 * 
 */
package com.yctxkj.blog.controller.admin;

import com.jfinal.core.Controller;

/**
 * @author jiftle
 *
 */
public class IndexController extends Controller {

	//提供静态页面资源
	public void index(){
		this.renderFreeMarker("index.ftl");
	}
	
	
}
