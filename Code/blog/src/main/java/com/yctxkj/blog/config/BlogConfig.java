package com.yctxkj.blog.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.ext.handler.FakeStaticHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.yctxkj.blog.config.Route.AdminRoutes;
import com.yctxkj.blog.config.Route.FrontRoutes;

public class BlogConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// 设置模板引擎
		me.setViewType(ViewType.FREE_MARKER);

		boolean bDevMode = PropKit.use("db.properties").getBoolean("devMode", false);

		me.setDevMode(bDevMode);
	}

	@Override
	public void configEngine(Engine arg0) {

	}

	@Override
	public void configHandler(Handlers me) {
		me.add(new FakeStaticHandler(".jhtml"));
		me.add(new ContextPathHandler("ctx"));
	}

	@Override
	public void configInterceptor(Interceptors arg0) {

	}

	// 配置插件
	@Override
	public void configPlugin(Plugins me) {
		// 配置druid数据库连接池插件
		DruidPlugin druidPlugin = createDruidPlugin();
		me.add(druidPlugin);

		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		// 所有映射在 MappingKit 中自动化搞定
		com.yctxkj.blog.model._MappingKit.mapping(arp);
		me.add(arp);

	}

	// 配置路由
	@Override
	public void configRoute(Routes me) {
		me.add(new FrontRoutes());
		me.add(new AdminRoutes());
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
