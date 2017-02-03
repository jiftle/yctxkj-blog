/**
 * 
 */
package com.yctxkj.blog.controller.admin;

import com.jfinal.core.ActionKey;
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
