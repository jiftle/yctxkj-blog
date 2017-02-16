package com.yctxkj.blog.controller.admin;

import javax.servlet.http.HttpServletRequest;

import com.baidu.ueditor.ActionEnter;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.kit.PathKit;
import com.yctxkj.blog.interceptor.AdminInterceptor;

/**
 * 
 * @ClassName: UeditorController 
 * @Description: Ueditor编辑器
 * @author jiftle
 * @date 2017年2月16日 下午4:33:27 
 * @Copyright: 赢创天下科技有限公司
 *  
 *
 */
//@Before({SessionInViewInterceptor.class,AdminInterceptor.class})
public class UeditorController extends Controller {
	public void index() {}
	
	public void controller(){

		HttpServletRequest request = this.getRequest();
		String rootPath = PathKit.getWebRootPath();

		String outText =  new ActionEnter(request, rootPath).exec();
		
		this.renderHtml(outText);
	}
}
