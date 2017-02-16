/**   
 * @Title: LoginValidator.java 
 * @Package com.yctxkj.blog.validator.admin.login 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author jiftle
 * @date 2017年2月13日 下午7:26:59
 * @version V1.0
 * @Copyright: 赢创天下科技有限公司
 *   
 */
package com.yctxkj.blog.validator.admin.login;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/** 
 * @ClassName: LoginValidator 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author jiftle
 * @date 2017年2月13日 下午7:26:59 
 * @Copyright: 赢创天下科技有限公司
 *  
 *  
 */
public class LoginValidator extends Validator {

	/*
	 * Title: validate
	 * Description: 
	 *  @param c 
	 *  @see com.jfinal.validate.Validator#validate(com.jfinal.core.Controller) 
	 */
	@Override
	protected void validate(Controller c) {
		validateRequiredString("username","usernameMsg","请输入用户名");
		validateRequiredString("pwd","pwdMsg","请输入密码");
	}

	/*
	 * Title: handleError
	 * Description: 
	 *  @param c 
	 *  @see com.jfinal.validate.Validator#handleError(com.jfinal.core.Controller) 
	 */
	@Override
	protected void handleError(Controller c) {
//		c.keepPara("name");
//		c.render("login/login-1.ftl");
	}

}
