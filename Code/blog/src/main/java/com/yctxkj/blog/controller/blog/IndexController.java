package com.yctxkj.blog.controller.blog;

import java.util.List;

import com.jfinal.core.Controller;
import com.yctxkj.blog.model.ArticleCategory;
import com.yctxkj.blog.service.ArticleCategoryService;

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
			System.out.println(list.toString());
			
			this.setAttr("list", list);
			
			this.render("index.ftl");
		}
}
