/**
 * 
 */
package com.yctxkj.blog.controller.admin;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.ehcache.CacheInterceptor;
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
public class ArticleController extends Controller {

	@Before(CacheInterceptor.class)
	public void list() {

		List<Article> list = ArticleService.findAll();
		System.out.println(list.toString());

		this.setAttr("list", list);

		this.render("article/list.ftl");
	}

	@Before(CacheInterceptor.class)
	public void add() {

		this.render("article/add.ftl");
	}

	/**
	 * 
	 * @Title: edit @Description: TODO(这里用一句话描述这个方法的作用) @param 参数说明 @return void
	 * 返回类型 @throws
	 */
	public void edit() {

		Long id = this.getParaToLong("id");
		Article article = Article.dao.findById(id);

		this.setAttr("article", article);

		this.render("article/edit.ftl");
	}

	/**
	 * @Title: del @Description: 删除 @param 参数说明 @return void 返回类型 @throws
	 */
	public void del() {
		Long id = this.getParaToLong("id");

		boolean bRet = Article.dao.deleteById(id);

		Ret ret = new Ret();
		if (!bRet) {
			ret.setFail();
			this.renderJson(ret);
		}

		this.redirect("/admin/article/list");
	}

	/**
	 * 
	 * @Title: save @Description: TODO(这里用一句话描述这个方法的作用) @param 参数说明 @return void
	 * 返回类型 @throws
	 */
	public void save() {
		boolean bRet = false;
		String title = this.getPara("title");
		String content = this.getPara("content");
		Article article = new Article();

		article.set("title", title).set("content", content).set("create_date", DateUtils.getCurDateTime())
				.set("modify_date", DateUtils.getCurDateTime());
		bRet = article.save();

		if (!bRet) {
			this.renderJson(new Ret().setFail().set("msg", "保存失败"));
			return;
		}

		this.redirect("/admin/article/list");
	}

	public void update() {
		boolean bRet = false;
		Long id = this.getParaToLong("id");
		String title = this.getPara("title");
		String content = this.getPara("content");
		String summary = this.getPara("summary");
		Article article = Article.dao.findById(id);

		if(summary.length() > 256){
			summary = summary.substring(0, 256);
		}
		
		DateTime now = DateTime.now(TimeZone.getDefault());
		String strTime = now.format("YYYY-MM-DD hh:mm:ss");

		article.set("title", title);
		article.set("content", content);
		article.set("modify_date", DateUtils.getCurDateTime());
		article.set("summary", summary);
		
		bRet = article.update();
		if (!bRet) {
			this.renderJson(new Ret().setFail().set("msg", "修改失败"));
			return;
		}

		this.redirect("/admin/article/list");
	}
}
