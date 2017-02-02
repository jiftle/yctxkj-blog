/**   
* @Title: LoginController.java 
* @Package com.yctxkj.blog.controller.admin.login 
* @Description: TODO(用一句话描述该文件做什么) 
* @author jiftle
* @date 2017年2月2日 下午4:43:21 
* @version V1.0   
*/
package com.yctxkj.blog.controller.admin.login;

import com.jfinal.core.Controller;

/** 
* @ClassName: LoginController 
* @Description: 登录控制器 
* @author jiftle
* @date 2017年2月2日 下午4:43:21 
*  
*/
public class LoginController extends Controller {

	public void index(){
		
	}
	
	public void login(){
		this.render("login/login-1.ftl");
	}
	
}
