package com.lin.webservice.service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.lin.webservice.service.bean.User;

/**
 * 
 * desc:   算术服务
 * @author xuelin
 * @date   Nov 11, 2015
 */
@WebService
public interface ArithmeticService {
	
	@WebResult(name = "addResult")
	public int add(@WebParam(name = "a")int a, @WebParam(name = "b")int b);
	
	@WebResult(name = "loginResult")
	public User login(@WebParam(name = "username")String username, @WebParam(name = "password")String password);
	
}
