/**
 * 
 */
package com.yctxkj.blog.controller.admin;

import java.util.List;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.kit.Ret;
import com.yctxkj.blog.interceptor.AdminInterceptor;
import com.yctxkj.blog.model.FriendLink;
import com.yctxkj.blog.util.DateUtils;

/**
 * 
 * @ClassName: FriendLinkController 
 * @Description: 友情链接管理
 * @author jiftle
 * @date 2017年2月18日 下午3:38:28 
 * @Copyright: 赢创天下科技有限公司
 *  
 *
 */
@Before({SessionInViewInterceptor.class,AdminInterceptor.class})
public class FriendLinkController extends Controller {

	public void list() {
		String sql = "select * from xx_friend_link;";
		List<FriendLink> friendLinkList = FriendLink.dao.find(sql);
		
		this.setAttr("friendLinkList", friendLinkList);

		this.render("friend_link/list.ftl");
	}

	public void add() {

		this.render("friend_link/add.ftl");
	}

	/**
	 * 
	 * @Title: edit @Description: TODO(这里用一句话描述这个方法的作用) @param 参数说明 @return void
	 *         返回类型 @throws
	 */
	public void edit() {

		Long id = this.getParaToLong("id");
		FriendLink friendLink = FriendLink.dao.findById(id);

		this.setAttr("friendLink", friendLink);

		this.render("friend_link/edit.ftl");
	}

	/**
	 * @Title: del @Description: 删除 @param 参数说明 @return void 返回类型 @throws
	 */
	
	public void del() {
		Long id = this.getParaToLong("id");

		boolean bRet = FriendLink.dao.deleteById(id);

		Ret ret = new Ret();
		if (!bRet) {
			ret.setFail();
			this.renderJson(ret);
		}

		this.redirect("/admin/friend_link/list");
	}

	
	public void save() {
		String name = this.getPara("name");
		String url = this.getPara("url");
		
		FriendLink friendLink = new FriendLink();
		friendLink.set("create_date", DateUtils.getCurDateTime());
		friendLink.set("modify_date", DateUtils.getCurDateTime());
		friendLink.set("name", name);
		friendLink.set("url", url);
		friendLink.save();
		
		this.redirect("/admin/friend_link/list");
	}

	
	public void update() {
		String id = this.getPara("id");
		String name = this.getPara("name");
		String url = this.getPara("url");
		
		FriendLink friendLink = FriendLink.dao.findById(id);
		friendLink.set("modify_date", DateUtils.getCurDateTime());
		friendLink.set("name", name);
		friendLink.set("url", url);
		friendLink.update();
		
		this.redirect("/admin/friend_link/list");
	}
}
