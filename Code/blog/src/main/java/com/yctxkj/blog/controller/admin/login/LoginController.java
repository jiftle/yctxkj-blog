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
	 * @Title: submit @Description: TODO(这里用一句话描述这个方法的作用) @param 参数说明 @return
	 *         void 返回类型 @throws
	 */
	public void submit() {
		String username = this.getPara("username");
		String pwd = this.getPara("pwd");
		String sql = "";
		Ret ret = ret = new Ret();

		sql = String.format("select * from xx_admin where username = '%s' and `password`='%s';", username, pwd);
		Admin admin = Admin.dao.findFirst(sql);

		if (admin == null) {
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

		this.redirect("/admin/index");
	}

	/**
	 * 
	 * @Title: logout @Description: TODO(这里用一句话描述这个方法的作用) @param 参数说明 @return
	 * void 返回类型 @throws
	 */
	public void logout() {
		Admin admin = this.getSessionAttr("loginAdmin");

		WebUtils.deleteCookie(this.getRequest(), this.getResponse(), "loginAdmin");
		setSessionAttr("loginAdmin", null);

		this.redirect("/admin/login/index");
	}
}
