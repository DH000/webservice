package com.lin.umws.interceptor;

import java.util.Iterator;
import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

public class OutInterceptor extends AbstractSoapInterceptor {
	
	public OutInterceptor(String p) {
		super(p);
	}

	public OutInterceptor(){
		// 读
		super(Phase.READ);
	}
	
	@Override
	public void handleMessage(SoapMessage soapMessage) throws Fault {
		System.out.println("---------------------OutInterceptor----------------------");
		List<Header> headers = soapMessage.getHeaders();
		for(Iterator<Header> iter = headers.iterator(); iter.hasNext();){
			Header header = iter.next();
			System.out.println(header.getName());
		}
		System.out.println("---------------------OutInterceptor----------------------");
	}
	
}
