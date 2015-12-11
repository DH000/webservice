package com.lin.umws.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import com.lin.umws.service.client.IUserService;
import com.lin.umws.service.client.User;

public class ClientTest {
	
	@Test
	public void addTest(){
//		UserService userService = new UserService();
//		userService.getUserServicePort().add(new User(3, "admin3", "123", 2));
		
		JaxWsProxyFactoryBean fac = new JaxWsProxyFactoryBean();
		fac.setServiceClass(IUserService.class);
		fac.setAddress("http://localhost:8888/us");
		IUserService userService = (IUserService)fac.create();
		userService.add(new User(1, "admin1", "123", 1));
	}
	
}
