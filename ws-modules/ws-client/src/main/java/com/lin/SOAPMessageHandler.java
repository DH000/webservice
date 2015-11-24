package com.lin;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SOAPMessageHandler implements SOAPHandler<SOAPMessageContext> {

	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("handleMessage invoked.");
		return false;
	}

	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("handleFault invoked.");
		return false;
	}

	public void close(MessageContext context) {
		System.out.println("close SOAPMessageHandler invoked.");
	}

	public Set<QName> getHeaders() {
		System.out.println("getHeaders invoked.");
		return null;
	}
	
}
