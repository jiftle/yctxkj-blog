package com.yctxkj.blog.controller.blog;

import com.jfinal.core.Controller;

public class IndexController extends Controller {

	//提供静态页面资源
		public void index(){
			this.renderFreeMarker("/blog/index.ftl");
		}
}
