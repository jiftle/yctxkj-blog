package com.yctxkj.blog.controller.blog;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.ehcache.CacheInterceptor;
import com.jfinal.plugin.ehcache.CacheName;
import com.yctxkj.blog.model.Article;
import com.yctxkj.blog.model.ArticleCategory;
import com.yctxkj.blog.model.FriendLink;
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
	@CacheName("blogIndex")
	public void index() {
		List<ArticleCategory> list = ArticleCategoryService.findAll();
		List<Article> listArticle = Article.dao.find("select * from xx_article order by id desc limit 5;");
		List<FriendLink> listFriendLink = FriendLink.dao.find("select * from xx_friend_link;");
		
		this.setAttr("app", PropKit.use("config.properties").get("app.version"));
		this.setAttr("list", list);
		this.setAttr("listArticle", listArticle);
		this.setAttr("listFriendLink", listFriendLink);
		
		this.render("index.ftl");
	}

	// 列表页
//	@Before(CacheInterceptor.class)
//	@CacheName("blogList")
	public void list() {
		String id = this.getPara("id");
		String sql = String.format("select * from xx_article where article_category = %s order by id desc;",id);
		
		List<ArticleCategory> list = ArticleCategoryService.findAll();
		List<Article> listArticle = Article.dao.find(sql);
		List<FriendLink> listFriendLink = FriendLink.dao.find("select * from xx_friend_link;");
		
		this.setAttr("app", PropKit.use("config.properties").get("app.version"));
		this.setAttr("list", list);
		this.setAttr("listArticle", listArticle);
		this.setAttr("listFriendLink", listFriendLink);

		this.render("list.ftl");
	}

	//详情页
//	@Before(CacheInterceptor.class)
//	@CacheName("blogArticle")
	public void article() {
		Long id = this.getParaToLong("id");

		Article article = Article.dao.findById(id);
		List<ArticleCategory> list = ArticleCategoryService.findAll();
		List<Article> listArticle = ArticleService.findAll();
		List<FriendLink> listFriendLink = FriendLink.dao.find("select * from xx_friend_link;");
		
		this.setAttr("app", PropKit.use("config.properties").get("app.version"));
		this.setAttr("article", article);
		this.setAttr("list", list);
		this.setAttr("listArticle", listArticle);
		this.setAttr("listFriendLink", listFriendLink);

		this.render("article.ftl");
	}

}
