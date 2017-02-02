/**   
* @Title: ArticleCategoryService.java 
* @Package com.yctxkj.blog.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author jiftle
* @date 2017年2月2日 下午11:56:08 
* @version V1.0   
*/
package com.yctxkj.blog.service;

import java.util.List;

import com.yctxkj.blog.model.ArticleCategory;

/** 
* @ClassName: ArticleCategoryService 
* @Description: 
* @author jiftle
* @date 2017年2月2日 下午11:56:08 
*  
*/
public class ArticleCategoryService {

	/*
	* Title: findAll
	* Description: 
	*  @return 
	*  @see com.yctxkj.blog.service.ArticleCategoryService#findAll() 
	*/
	public static List<ArticleCategory> findAll() {
		String sql = "select * from xx_article_category";
		
		return ArticleCategory.dao.find(sql);
	}

}
