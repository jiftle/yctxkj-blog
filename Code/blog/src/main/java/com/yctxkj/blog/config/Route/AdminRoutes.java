/**
 * 
 */
package com.yctxkj.blog.config.Route;

import com.jfinal.config.Routes;
import com.yctxkj.blog.controller.admin.IndexController;

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
	}

}
