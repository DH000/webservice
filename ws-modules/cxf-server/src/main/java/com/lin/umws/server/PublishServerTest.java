package com.lin.umws.server;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.lin.umws.interceptor.InInterceptor;
import com.lin.umws.interceptor.OutInterceptor;
import com.lin.umws.service.impl.UserServiceImpl;

public class PublishServerTest {
	public static void main(String[] args) {
		JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
		factoryBean.setAddress("http://localhost:8888/us");
		factoryBean.setServiceClass(UserServiceImpl.class);
		factoryBean.setWsdlLocation("wsdl/user-doc.wsdl");
		factoryBean.getInInterceptors().add(new InInterceptor());
		factoryBean.getOutInterceptors().add(new OutInterceptor());
		factoryBean.create();
	}
}
