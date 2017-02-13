package com.yctxkj.blog.controller.blog;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.ehcache.CacheInterceptor;
import com.yctxkj.blog.model.Article;
import com.yctxkj.blog.model.ArticleCategory;
import com.yctxkj.blog.service.ArticleCategoryService;
import com.yctxkj.blog.service.ArticleService;

/**
 * 前台
 * 
 * @author jiftle
 *
 */
public class IndexController extends Controller {

	//首页
	@Before(CacheInterceptor.class)
	public void index() {
		List<ArticleCategory> list = ArticleCategoryService.findAll();
		List<Article> listArticle = ArticleService.findAll();

		this.setAttr("app", PropKit.use("config.properties").get("app.version"));
		this.setAttr("list", list);
		this.setAttr("listArticle", listArticle);

		this.render("index.ftl");
	}

	// 列表页
	@Before(CacheInterceptor.class)
	public void list() {
		List<ArticleCategory> list = ArticleCategoryService.findAll();
		List<Article> listArticle = ArticleService.findAll();

		this.setAttr("app", PropKit.use("config.properties").get("app.version"));
		this.setAttr("list", list);
		this.setAttr("listArticle", listArticle);

		this.render("list.ftl");
	}

	//详情页
	@Before(CacheInterceptor.class)
	public void article() {
		Long id = this.getParaToLong("id");

		Article article = Article.dao.findById(id);
		List<ArticleCategory> list = ArticleCategoryService.findAll();
		List<Article> listArticle = ArticleService.findAll();

		this.setAttr("app", PropKit.use("config.properties").get("app.version"));
		this.setAttr("article", article);
		this.setAttr("list", list);
		this.setAttr("listArticle", listArticle);

		this.render("article.ftl");
	}

}
