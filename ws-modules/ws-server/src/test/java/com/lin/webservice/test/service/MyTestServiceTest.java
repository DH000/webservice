package com.lin.webservice.test.service;

import javax.xml.ws.Endpoint;

import com.lin.webservice.service.impl.test1.MyTestServiceImpl;
import com.lin.webservice.test.Constants;

public class MyTestServiceTest {
	public static void main(String[] args) {
		Endpoint.publish(Constants.PUBLISH_URL, new MyTestServiceImpl());
	}
}
