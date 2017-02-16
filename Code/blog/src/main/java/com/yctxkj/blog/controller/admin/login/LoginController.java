/**   
* @Title: LoginController.java 
* @Package com.yctxkj.blog.controller.admin.login 
* @Description: TODO(用一句话描述该文件做什么) 
* @author jiftle
* @date 2017年2月2日 下午4:43:21 
* @version V1.0   
*/
package com.yctxkj.blog.controller.admin.login;

import com.jfinal.captcha.CaptchaRender;
import com.jfinal.core.Controller;
import com.jfinal.kit.HashKit;
import com.jfinal.kit.Ret;
import com.yctxkj.blog.model.Admin;
import com.yctxkj.blog.util.WebUtils;

/**
 * @ClassName: LoginController
 * @Description: 登录控制器
 * @author jiftle
 * @date 2017年2月2日 下午4:43:21
 * 
 */
public class LoginController extends Controller {

	public void index() {
		this.render("login/login-1.ftl");
	}

	/**
	 * 
	 * @Title: captchaImg 
	 * @Description: 验证码图片 
	 * @param   参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	public void captcha_img() {  
        CaptchaRender img = new CaptchaRender();  
        render(img);  
    }  
	
	
	/**
	 * 
	 * @Title: submit @Description: 提交表单
	 *  @param 参数说明 @return
	 * void 返回类型 @throws
	 */
//	@Before(LoginValidator.class)
	public void submit() {
		String username = this.getPara("username");
		String pwd = this.getPara("pwd");
		String sql = "";
		
		String captcha = this.getPara("captcha");

		//处理参数
		if(CaptchaRender.validate(this, captcha) == false){
			Ret ret = new Ret();
			ret.setFail();
			ret.set("msg","验证码错误");
			
			this.renderJson(ret);
			return;
		}
		
		pwd = HashKit.md5(pwd);
		sql = String.format("select * from xx_admin where username = '%s' and `password`='%s';", username, pwd);
		Admin admin = Admin.dao.findFirst(sql);

		if (admin == null) {
			Ret ret = new Ret();
			ret.setFail();
			ret.set("msg", "登录失败，用户名或密码不正确。");

			this.renderJson(ret);
			return;
		}

		setSessionAttr("loginAdmin", admin);
		setAttr("username", admin.getStr("username"));
		setAttr("name", admin.getStr("name"));

		WebUtils.setCookie(getResponse(), "username", admin.getStr("username"));
		WebUtils.setCookie(getResponse(), "name", admin.getStr("name"));

		Ret ret = new Ret();
		ret.setOk();
		ret.set("msg", "登录成功");
		
		this.renderJson(ret);
		
//		this.redirect("/admin/index");
	}

	/**
	 * 
	 * @Title: logout @Description: TODO(这里用一句话描述这个方法的作用) @param 参数说明 @return
	 *         void 返回类型 @throws
	 */
	public void logout() {
		Admin admin = this.getSessionAttr("loginAdmin");

		WebUtils.deleteCookie(this.getRequest(), this.getResponse(), "loginAdmin");
		setSessionAttr("loginAdmin", null);

		this.redirect("/admin/login/index");
	}
}
