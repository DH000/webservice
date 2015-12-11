package com.lin.umws.client;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.databinding.DataBinding;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.ClientCallback;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.jaxws.JaxWsClientFactoryBean;
import org.apache.cxf.phase.Phase;
import org.junit.Test;

import com.lin.umws.entity.User;
import com.lin.umws.service.IUserService;

public class UserServiceClient {
	
	@Test
	public void addTest(){
		JaxWsClientFactoryBean factoryBean = new JaxWsClientFactoryBean();
		factoryBean.setAddress("http://localhost:8888/us");
		factoryBean.setServiceClass(IUserService.class);
		factoryBean.getOutInterceptors().add(new AbstractSoapInterceptor(Phase.WRITE) {
			@Override
			public void handleMessage(SoapMessage message) throws Fault {
				DataBinding db = null;
				try {
					db = new JAXBDataBinding(User.class);
				} catch (JAXBException e) {
					e.printStackTrace();
				}
				message.getHeaders().add(new Header(new QName("http://service.umws.lin.com/", "licenseType"), new User(1, "admin1", "123", 1), db));
			}
		});
		
		Client client = factoryBean.create();
		ClientCallback back = new ClientCallback();
		try {
			client.invoke(back, new QName("http://service.umws.lin.com/", "add"), new User(2, "admin2", "123", 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
