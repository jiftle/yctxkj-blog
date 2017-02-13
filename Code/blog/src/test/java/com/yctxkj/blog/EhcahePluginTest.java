package com.yctxkj.blog;

import org.junit.Before;
import org.junit.Test;

import com.jfinal.plugin.ehcache.CacheKit;
import com.jfinal.plugin.ehcache.EhCachePlugin;

/** 
 * @ClassName: EhcahePluginTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author jiftle
 * @date 2017年2月11日 下午10:08:27 
 * @Copyright: 赢创天下科技有限公司
 *  
 *  
 */
public class EhcahePluginTest {

	@Before
	public void setUp(){
		EhCachePlugin ehCachePlugin = new EhCachePlugin();
		
		ehCachePlugin.start();
	}
	
	String cacheName = "session";
	
	@Test
	public void TestGet(){
//		CacheKit.put(cacheName, "key", "100");
		String value = CacheKit.get(cacheName, "key");
		
		System.out.println(value);
	}
	
	@Test
	public void TestPut(){
		String value = "100";
		CacheKit.put(cacheName, "key", value);
		
		
	}
	
	
}
