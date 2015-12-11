package com.lin.webservice.service;

import java.util.List;

import javax.jws.HandlerChain;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.lin.webservice.service.bean.User;

@WebService
public interface MyService {
	
	@WebResult(name = "user")
	public User addUser(@WebParam(name = "user")User user);
	
	@WebResult(name = "user")
	public User login(@WebParam(name = "username")String username, @WebParam(name = "password")String password) throws Exception;
	
	@WebResult(name = "user")
	public List<User> list();
	
	public void headerMessage(@WebParam(header = true, name = "authInfo") String authInfo);
	
}
