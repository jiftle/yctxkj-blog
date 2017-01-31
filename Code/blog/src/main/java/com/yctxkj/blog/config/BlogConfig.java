package com.yctxkj.blog.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.FakeStaticHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class BlogConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		// me.setDevMode(true);

		boolean bDevMode = PropKit.use("db.properties").getBoolean("devMode", false);

		me.setDevMode(bDevMode);
	}

	@Override
	public void configEngine(Engine arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		me.add(new FakeStaticHandler(".html"));
	}

	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configPlugin(Plugins arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configRoute(Routes me) {
		me.add("/admin", com.yctxkj.blog.controller.admin.IndexController.class);
		me.add("/", com.yctxkj.blog.controller.blog.IndexController.class);
	}

	/**
	 * druid
	 * 
	 * @return
	 */
	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
	}

}
