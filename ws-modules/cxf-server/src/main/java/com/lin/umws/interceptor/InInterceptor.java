package com.lin.umws.interceptor;

import java.util.Iterator;
import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

/**
 * 
 * desc:   进入服务器
 * @author xuelin
 * @date   Nov 25, 2015
 */
public class InInterceptor extends AbstractSoapInterceptor {

	public InInterceptor(String phase) {
		super(phase);
	}
	
	public InInterceptor(){
		super(Phase.UNMARSHAL);
	}

	@Override
	public void handleMessage(SoapMessage soapMessage) throws Fault {
		System.out.println("---------------------InInterceptor----------------------");
		List<Header> headers = soapMessage.getHeaders();
		for(Iterator<Header> iter = headers.iterator(); iter.hasNext();){
			Header header = iter.next();
			Element ele = (Element) header.getObject();
			System.out.println("id: " + ele.getElementsByTagName("id").item(0).getTextContent());
			System.out.println("id: " + ele.getElementsByTagName("username").item(0).getTextContent());
			System.out.println("id: " + ele.getElementsByTagName("password").item(0).getTextContent());
			System.out.println("id: " + ele.getElementsByTagName("sex").item(0).getTextContent());
		}
		System.out.println("---------------------InInterceptor----------------------");
	}
	
}
