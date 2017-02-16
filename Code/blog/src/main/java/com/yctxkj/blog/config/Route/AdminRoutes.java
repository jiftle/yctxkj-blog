/**
 * 
 */
package com.yctxkj.blog.config.Route;

import com.jfinal.config.Routes;
import com.yctxkj.blog.controller.admin.AdminController;
import com.yctxkj.blog.controller.admin.ArticleController;
import com.yctxkj.blog.controller.admin.CategoryController;
import com.yctxkj.blog.controller.admin.IndexController;
import com.yctxkj.blog.controller.admin.UeditorController;
import com.yctxkj.blog.controller.admin.login.LoginController;

/**
 * @author jiftle
 *
 */
public class AdminRoutes extends Routes {

	/* (non-Javadoc)
	 * @see com.jfinal.config.Routes#config()
	 */
	@Override
	public void config() {
		setBaseViewPath("/template/admin");
		
		this.add("/admin/login",LoginController.class,"/");
		this.add("/admin/category",CategoryController.class,"/");
		this.add("/admin/article",ArticleController.class,"/");
		this.add("/admin/admin",AdminController.class,"/");
		this.add("/admin",IndexController.class,"/");
		this.add("/admin/ueditor",UeditorController.class,"/");
	}

	
	
}
