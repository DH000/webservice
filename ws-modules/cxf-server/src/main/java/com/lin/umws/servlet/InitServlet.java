package com.lin.umws.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {

	/**
	 * desc: TODO
	 */
	private static final long serialVersionUID = 1980188317842283477L;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		System.out.println("初始化服务器...");
	}
	
	public static void main(String[] args) {
		
	}
	
}
