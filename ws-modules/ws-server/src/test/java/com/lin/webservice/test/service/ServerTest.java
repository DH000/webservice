package com.lin.webservice.test.service;

import javax.xml.ws.Endpoint;

import com.lin.webservice.service.impl.MyServiceImpl;
import com.lin.webservice.test.Constants;

/**
 * 
 * desc:   webservice server
 * @author xuelin
 * @date   Nov 11, 2015
 */
public class ServerTest {
	
	public static void main(String[] args) {
//		Endpoint.publish(Constants.PUBLISH_URL, new ArithmeticServiceImpl());
		Endpoint.publish(Constants.PUBLISH_URL, new MyServiceImpl());
	}
	
}









