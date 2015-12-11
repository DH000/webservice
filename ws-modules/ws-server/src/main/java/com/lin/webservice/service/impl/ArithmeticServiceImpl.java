package com.lin.webservice.service.impl;

import javax.jws.WebService;

import com.lin.webservice.service.ArithmeticService;
import com.lin.webservice.service.bean.User;

/**
 * 
 * desc:   算术服务
 * @author xuelin
 * @date   Nov 11, 2015
 */
@WebService(endpointInterface = "com.lin.webservice.service.ArithmeticService")
public class ArithmeticServiceImpl implements ArithmeticService {
	
	public int add(int a, int b) {
		int res = a + b;
		System.out.println(a + " + " + b + " = " + (res));
		return res;
	}

	public User login(String username, String password) {
		return new User(username, password);
	}
	
}




