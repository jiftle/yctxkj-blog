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
import com.jfinal.plugin.ehcache.CacheName;
import com.jfinal.plugin.ehcache.EvictInterceptor;
import com.yctxkj.blog.model.ArticleCategory;
import com.yctxkj.blog.service.ArticleCategoryService;

import hirondelle.date4j.DateTime;

/**
 * 后台
 * 
 * @author jiftle
 *
 */
@Before(SessionInViewInterceptor.class)
public class CategoryController extends Controller {

//	@Before(CacheInterceptor.class)
//	@CacheName("articleCategory")
	public void list(){
		
		List<ArticleCategory> list = ArticleCategoryService.findAll();
		
		this.setAttr("list", list);
		
		this.render("category/list.ftl");
	}
	
	public void add(){
		
		this.render("category/add.ftl");
	}
	
	/**
	 * 
	 * @Title: edit 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param   参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	public void edit(){
		
		Long id = this.getParaToLong("id");
		ArticleCategory articleCategory = ArticleCategory.dao.findById(id);
		
		this.setAttr("articleCategory", articleCategory);
		
		this.render("category/edit.ftl");
	}
	
	
	
	
	/**
	 * @Title: del 
	 * @Description: 删除
	 * @param   参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	@Before(EvictInterceptor.class)
	@CacheName("blogList")
	public void del(){
		Long id = this.getParaToLong("id");
		
		boolean bRet = ArticleCategory.dao.deleteById(id);
		
		Ret ret = new Ret();
		if(!bRet){
			ret.setFail();
			this.renderJson(ret);
		}
		
		
		this.redirect("/admin/category/list");
	}
	
	/**
	 * 
	 * @Title: save 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param   参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	@Before(EvictInterceptor.class)
	@CacheName("blogList")
	public void save(){
		boolean bRet = false;
		String categoryName = this.getPara("name");
		ArticleCategory articleCategory = new ArticleCategory();
		
		articleCategory.set("name", categoryName);
		bRet = articleCategory.save();
		
		if(!bRet){
			this.renderJson(new Ret().setFail().set("msg", "保存失败"));
			return;
		}
		
		this.redirect("/admin/category/list");
	}
	
	@Before(EvictInterceptor.class)
	@CacheName("blogList")
	public void update(){
		boolean bRet = false;
		Long id = this.getParaToLong("id");
		String name = this.getPara("name");
		ArticleCategory articleCategory = ArticleCategory.dao.findById(id);
	
		 DateTime now = DateTime.now(TimeZone.getDefault());
	     String strTime = now.format("YYYY-MM-DD hh:mm:ss");
	        
		articleCategory.set("name", name).set("modify_date", strTime);
		bRet = articleCategory.update();
		if(!bRet){
			this.renderJson(new Ret().setFail().set("msg","修改失败"));
			return;
		}
		
		this.redirect("/admin/category/list");
	}
}
