/**
 * 
 */
package com.yctxkj.blog.config.Route;

import com.jfinal.config.Routes;
import com.yctxkj.blog.controller.admin.CategoryController;
import com.yctxkj.blog.controller.admin.IndexController;
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
		this.add("/admin",IndexController.class,"/");
		this.add("/admin/login",LoginController.class,"/");
		this.add("/admin/category",CategoryController.class,"/");
	}

	
	
}