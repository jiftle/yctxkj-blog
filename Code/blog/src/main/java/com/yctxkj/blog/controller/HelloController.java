package com.yctxkj.blog.controller;

import javax.servlet.ServletContext;

import com.jfinal.core.Controller;

public class HelloController extends Controller {

	public void index(){
		String serverName = this.getRequest().getServerName();
		
		serverName = System.getProperty("os.name");
		serverName = this.getRequest().getSession().getServletContext().getServerInfo();
		this.renderText("hello JFinal Work. this is jetty.\n" + serverName);
		
//		String text = "Hello ,你好。";
//		this.renderText(text);
		
		String text = "";
		ServletContext servletContext = this.getRequest().getSession().getServletContext();
		
		text = servletContext.getMajorVersion() + "." + servletContext.getMinorVersion();
		
		this.renderText(text);

	}
}
