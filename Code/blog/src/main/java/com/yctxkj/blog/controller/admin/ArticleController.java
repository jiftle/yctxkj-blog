/**
 * 
 */
package com.yctxkj.blog.controller.admin;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.ehcache.CacheInterceptor;
import com.jfinal.plugin.ehcache.CacheKit;
import com.jfinal.plugin.ehcache.CacheName;
import com.jfinal.plugin.ehcache.EvictInterceptor;
import com.yctxkj.blog.model.Article;
import com.yctxkj.blog.model.ArticleCategory;
import com.yctxkj.blog.service.ArticleCategoryService;
import com.yctxkj.blog.service.ArticleService;
import com.yctxkj.blog.util.DateUtils;

import hirondelle.date4j.DateTime;

/**
 * 后台
 * 
 * @author jiftle
 *
 */
@Before(SessionInViewInterceptor.class)
public class ArticleController extends Controller {

	public void list() {

		List<Article> list = ArticleService.findAll();

		this.setAttr("list", list);

		this.render("article/list.ftl");
	}

	public void add() {

		List<ArticleCategory> list = ArticleCategoryService.findAll();

		this.setAttr("categoryList", list);

		this.render("article/add.ftl");
	}

	/**
	 * 
	 * @Title: edit @Description: TODO(这里用一句话描述这个方法的作用) @param 参数说明 @return void
	 *         返回类型 @throws
	 */
	public void edit() {

		Long id = this.getParaToLong("id");
		Article article = Article.dao.findById(id);
		List<ArticleCategory> list = ArticleCategoryService.findAll();

		this.setAttr("categoryList", list);
		this.setAttr("article", article);

		this.render("article/edit.ftl");
	}

	/**
	 * @Title: del @Description: 删除 @param 参数说明 @return void 返回类型 @throws
	 */
	@Before(EvictInterceptor.class)
	@CacheName("blogList")
	public void del() {
		Long id = this.getParaToLong("id");

		boolean bRet = Article.dao.deleteById(id);

		Ret ret = new Ret();
		if (!bRet) {
			ret.setFail();
			this.renderJson(ret);
		}

		CacheKit.removeAll("blogIndex");
		this.redirect("/admin/article/list");
	}

	/**
	 * 
	 * @Title: save @Description: TODO(这里用一句话描述这个方法的作用) @param 参数说明 @return void
	 *         返回类型 @throws
	 */
	@Before(EvictInterceptor.class)
	@CacheName("blogList")
	public void save() {
		boolean bRet = false;
		String title = this.getPara("title");
		String summary = this.getPara("summary");
		String content = this.getPara("content");
		String category = this.getPara("category");
		Article article = new Article();

		article.set("title", title);
		article.set("summary", summary);
		article.set("content", content);
		article.set("article_category", category);
		article.set("create_date", DateUtils.getCurDateTime());
		article.set("modify_date", DateUtils.getCurDateTime());
		bRet = article.save();

		if (!bRet) {
			this.renderJson(new Ret().setFail().set("msg", "保存失败"));
			return;
		}

		CacheKit.removeAll("blogIndex");

		this.redirect("/admin/article/list");
	}

	@Before(EvictInterceptor.class)
	@CacheName("blogArticle")
	public void update() {
		boolean bRet = false;
		Long id = this.getParaToLong("id");
		String title = this.getPara("title");
		String content = this.getPara("content");
		String summary = this.getPara("summary");
		String category = this.getPara("category");
		
		Article article = Article.dao.findById(id);

		if (summary.length() > 256) {
			summary = summary.substring(0, 256);
		}

		DateTime now = DateTime.now(TimeZone.getDefault());
		String strTime = now.format("YYYY-MM-DD hh:mm:ss");

		article.set("title", title);
		article.set("content", content);
		article.set("modify_date", DateUtils.getCurDateTime());
		article.set("summary", summary);
		article.set("article_category", category);

		bRet = article.update();
		if (!bRet) {
			this.renderJson(new Ret().setFail().set("msg", "修改失败"));
			return;
		}

		CacheKit.removeAll("blogIndex");
		CacheKit.removeAll("blogList");
		this.redirect("/admin/article/list");
	}
}
