/**   
 * @Title: AdminController.java 
 * @Package com.yctxkj.blog.controller.admin 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author jiftle
 * @date 2017年2月11日 上午12:24:45
 * @version V1.0
 * @Copyright: 赢创天下科技有限公司
 *   
 */
package com.yctxkj.blog.controller.admin;

import com.jfinal.aop.Before;
import com.jfinal.captcha.CaptchaRender;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.kit.HashKit;
import com.jfinal.kit.Ret;
import com.yctxkj.blog.interceptor.AdminInterceptor;
import com.yctxkj.blog.model.Admin;
import com.yctxkj.blog.util.DateUtils;

/**
 * @ClassName: AdminController
 * @Description: 用户管理
 * @author jiftle
 * @date 2017年2月11日 上午12:24:45
 * @Copyright: 赢创天下科技有限公司
 * 
 * 
 */
@Before({SessionInViewInterceptor.class,AdminInterceptor.class})
public class AdminController extends Controller {


	/**
	 * 
	 * @Title: register @Description: 注册 @param 参数说明 @return void 返回类型 @throws
	 */
	public void register() {
		this.render("login/create-account.ftl");
	}

 
	
	/**
	 * @Title: submit @Description: 注册表单 @param 参数说明 @return
	 * void 返回类型 @throws
	 */
	public void submit() {

		//获取参数
		String username = this.getPara("username");
		String nickname = this.getPara("nickname");
		String email = this.getPara("email");
		String pwd = this.getPara("pwd");
		String repwd = this.getPara("repwd");
		String captcha = this.getPara("captcha");

		//处理参数
		if(CaptchaRender.validate(this, captcha) == false){
			Ret ret = new Ret();
			ret.setFail();
			ret.set("msg","验证码错误");
			
			this.renderJson(ret);
			return;
		}
		if(pwd.equals(repwd) == false){
			Ret ret = new Ret();
			ret.setFail();
			ret.set("msg","两次密码输入不一致");
			
			this.renderJson(ret);
			return;
		}
		String password = HashKit.md5(pwd);
		
		//写入数据库
		Admin admin = new Admin();
		admin.set("username", username);
		admin.set("email", email);
		admin.set("name", nickname);
		admin.set("password", password);
		admin.set("create_date", DateUtils.getCurDateTime());
		admin.set("modify_date", DateUtils.getCurDateTime());
		admin.set("is_enabled", "0");
		admin.save();
		
		//返回结果
		Ret ret = new Ret();
		ret.setOk();
		
		this.renderJson(ret);
		
	}
	

}
