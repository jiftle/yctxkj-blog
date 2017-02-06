package com.yctxkj.blog.controller.blog;

import java.util.List;

import com.jfinal.core.Controller;
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

	//提供静态页面资源
		public void index(){
			List<ArticleCategory> list = ArticleCategoryService.findAll();
			List<Article> listArticle = ArticleService.findAll();

			this.setAttr("list", list);
			this.setAttr("listArticle", listArticle);
			
			this.render("index.ftl");
		}
}
