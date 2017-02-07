/**   
* @Title: DateUtils.java 
* @Package com.yctxkj.blog.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author jiftle
* @date 2017年2月6日 下午6:37:43 
* @version V1.0
* @Copyright: 赢创天下科技有限公司
*   
*/
package com.yctxkj.blog.util;

import java.util.TimeZone;

import hirondelle.date4j.DateTime;

/**
 * 
 * @ClassName: DateUtils 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author jiftle
 * @date 2017年2月7日 下午7:53:56 
 * @Copyright: 赢创天下科技有限公司
 *  
 *
 */
public class DateUtils {

	/**
	 * @Title: getCurDateTime 
	 * @Description: 获取当前时间 
	 * @param @return  参数说明 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getCurDateTime(){
		DateTime now = DateTime.now(TimeZone.getDefault());
	    String strTime = now.format("YYYY-MM-DD hh:mm:ss");
	    return strTime;
	}
}
