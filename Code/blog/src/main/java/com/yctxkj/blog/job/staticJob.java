/**   
 * @Title: staticJob.java 
 * @Package com.yctxkj.blog.job 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author jiftle
 * @date 2017年2月13日 下午8:34:29
 * @version V1.0
 * @Copyright: 赢创天下科技有限公司
 *   
 */
package com.yctxkj.blog.job;

/** 
 * @ClassName: staticJob 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author jiftle
 * @date 2017年2月13日 下午8:34:29 
 * @Copyright: 赢创天下科技有限公司
 *  
 *  
 */
public class staticJob implements Runnable {

	/*
	 * Title: run
	 * Description:  
	 *  @see java.lang.Runnable#run() 
	 */
	@Override
	public void run() {
		
		System.out.println("-----------cron4j task-----------");

	}

}
