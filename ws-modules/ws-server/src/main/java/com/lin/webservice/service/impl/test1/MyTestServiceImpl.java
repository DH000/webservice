package com.lin.webservice.service.impl.test1;

import javax.jws.WebService;

import com.lin.webservice.service.test1.MyTestService;

@WebService(endpointInterface = "com.lin.webservice.service.test1.MyTestService", targetNamespace = "http://test1.service.webservice.lin.com/")
public class MyTestServiceImpl implements MyTestService {
	
	public int add(int a, int b, String license) {
		int res = a + b;
		System.out.println("license: " + license);
		System.out.println(a + " + " + b + " = " + res);
		return res;
	}
	
	public int divide(int num1, int num2) {
		int res = num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + res);
		return res;
	}
	
}
