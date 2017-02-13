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
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.druid.DruidStatViewHandler;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.yctxkj.blog.config.Route.AdminRoutes;
import com.yctxkj.blog.config.Route.FrontRoutes;
import com.yctxkj.blog.interceptor.ExecuteTimeInterceptor;

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
		// druid 路由排除掉，解决druid路由映射不正确的问题
		DruidStatViewHandler dvh = new DruidStatViewHandler("/druid");
		me.add(dvh);

		// me.add(new FakeStaticHandler(".html"));
		// 添加路径映射
		me.add(new ContextPathHandler("ctx"));
	}

	@Override
	public void configInterceptor(Interceptors me) {
		me.add(new ExecuteTimeInterceptor());
	}

	// 配置插件
	@Override
	public void configPlugin(Plugins me) {
		boolean bShowSql = PropKit.use("db.properties").getBoolean("showSql", false);

		// 配置druid数据库连接池插件
		DruidPlugin druidPlugin = createDruidPlugin();
		me.add(druidPlugin);

		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		arp.setShowSql(bShowSql);

		// 所有映射在 MappingKit 中自动化搞定
		com.yctxkj.blog.model._MappingKit.mapping(arp);
		me.add(arp);

		//EhCache缓存插件
		me.add(new EhCachePlugin());
		
		//Redis缓存插件
		me.add(new RedisPlugin("blog","localhost"));
		
		//Cron4j任务调度插件
		me.add(new Cron4jPlugin(PropKit.use("cron4j.properties"),"cron4j"));
	}

	// 配置路由
	@Override
	public void configRoute(Routes me) {
		me.add(new FrontRoutes());// 前端路由
		me.add(new AdminRoutes());// 后端路由
	}

	/**
	 * 初始化Druid插件
	 * 
	 * @return
	 */
	public static DruidPlugin createDruidPlugin() {
		DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"),
				PropKit.get("password").trim());

		return druidPlugin;
	}

}
