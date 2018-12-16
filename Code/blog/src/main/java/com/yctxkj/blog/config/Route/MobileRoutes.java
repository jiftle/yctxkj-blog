/**
 * 
 */
package com.yctxkj.blog.config.Route;

import com.jfinal.config.Routes;
import com.yctxkj.blog.controller.mobile.IndexController;


/**
 * @author jiftle
 *
 */
public class MobileRoutes extends Routes {

	/* (non-Javadoc)
	 * @see com.jfinal.config.Routes#config()
	 */
	@Override
	public void config() {
		setBaseViewPath("/template/mobile");
		this.add("/mobile",IndexController.class,"/");
	}

}
