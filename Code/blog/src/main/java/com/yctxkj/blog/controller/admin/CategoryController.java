/**
 * 
 */
package com.yctxkj.blog.controller.admin;


import java.util.List;

import com.jfinal.core.Controller;
import com.yctxkj.blog.model.ArticleCategory;
import com.yctxkj.blog.service.ArticleCategoryService;

/**
 * 后台
 * 
 * @author jiftle
 *
 */
public class CategoryController extends Controller {

	public void list(){
		
		List<ArticleCategory> list = ArticleCategoryService.findAll();
		System.out.println(list.toString());
		
		this.setAttr("list", list);
		this.setAttr("tg", "tg-------------value");
		
		
		this.renderFreeMarker("category/list.ftl");
	}
	
}
