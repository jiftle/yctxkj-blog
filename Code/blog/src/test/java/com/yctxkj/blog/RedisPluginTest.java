/**   
 * @Title: RedisPluginTest.java 
 * @Package com.yctxkj.blog 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author jiftle
 * @date 2017年2月13日 下午5:13:07
 * @version V1.0
 * @Copyright: 赢创天下科技有限公司
 *   
 */
package com.yctxkj.blog;

import com.jfinal.plugin.redis.Cache;
import com.jfinal.plugin.redis.Redis;
import com.jfinal.plugin.redis.RedisPlugin;

/** 
 * @ClassName: RedisPluginTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author jiftle
 * @date 2017年2月13日 下午5:13:07 
 * @Copyright: 赢创天下科技有限公司
 *  
 */
public class RedisPluginTest {

	public static void SetUp(){
	
		RedisPlugin redisPlugin = new RedisPlugin("main","localhost");
	
		redisPlugin.start();
	}
	
	public static void main(String[] args){
		SetUp();
		Cache cache;
		String key;
		String value;
		
//		Cache cache = Redis.use("main");
//		cache.set("name", "koal");
//		String value = cache.get("name");
//		
//		System.out.println(String.format("this %s is %s", "name",value));
		
		//------------------------
		key = "key1";
		cache = Redis.use("main");
		value = cache.get(key);
		
		System.out.println(String.format("%s = %s",key,value));
	}
	
	
}
