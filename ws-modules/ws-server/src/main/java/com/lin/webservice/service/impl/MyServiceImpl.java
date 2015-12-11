package com.lin.webservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.lin.webservice.service.MyService;
import com.lin.webservice.service.bean.User;

@WebService(endpointInterface = "com.lin.webservice.service.MyService")
public class MyServiceImpl implements MyService {
	
	private static List<User> users = new ArrayList<User>();
	
	static{
		users.add(new User(1, "admin1", "123"));
		users.add(new User(2, "admin2", "123"));
	}

	public User addUser(User user) {
		users.add(user);
		return user;
	}

	public User login(String username, String password) throws Exception {
		for(User user : users){
			if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
				return user;
			}
		}
		
		throw new Exception("用户不存在");
	}

	public List<User> list() {
		return users;
	}

	public void headerMessage(String authInfo) {
		System.out.println("authInfo: " + authInfo);
	}
	
}
