package com.yctxkj.blog.interceptor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;
import com.yctxkj.blog.model.Admin;

/**
 * 
 * @ClassName: AdminInterceptor 
 * @Description: 后台拦截器
 * @author jiftle
 * @date 2017年2月14日 下午11:57:44 
 * @Copyright: 赢创天下科技有限公司
 *  
 *
 */
public class AdminInterceptor implements Interceptor {

	private final Log logger = Log.getLog(getClass());

	@Override
	public void intercept(Invocation inv) {
		Controller controller = inv.getController();
		Admin admin = controller.getSessionAttr("loginAdmin");

		if (null != admin) {
			inv.invoke();
			return;
		}
		
		// 登陆页URL
		String loginPath = "/admin/login?from=%s";

		HttpServletRequest request = controller.getRequest();
		String queryString = request.getQueryString();
		// 被拦截前的请求URL
		String redirectUrl = request.getRequestURI();
		if (StrKit.notBlank(queryString)) {
			redirectUrl = redirectUrl.concat("?").concat(queryString);
		}
		try {
			redirectUrl = URLEncoder.encode(redirectUrl, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		}
		String tagPath = String.format(loginPath, redirectUrl);
		logger.info("login[redirectUrl]:\t" + tagPath);

		controller.redirect(tagPath);
	}

}
