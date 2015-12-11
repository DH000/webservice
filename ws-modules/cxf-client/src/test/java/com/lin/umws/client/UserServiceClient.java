package com.lin.umws.client;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.ClientCallback;
import org.apache.cxf.jaxws.JaxWsClientFactoryBean;
import org.junit.Test;

import com.lin.umws.service.client.IUserService;
import com.lin.umws.service.client.User;

public class UserServiceClient {
	
	@Test
	public void addTest(){
		JaxWsClientFactoryBean factoryBean = new JaxWsClientFactoryBean();
		factoryBean.setAddress("http://localhost:8888/us");
		factoryBean.setServiceClass(IUserService.class);
		Client client = factoryBean.create();
		ClientCallback back = new ClientCallback();
		try {
			client.invoke(back, new QName("http://service.umws.lin.com/", "add", "ns"), new User(3, "admin3", "123", 2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
} 
