package com.lin.webservice.handler;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SOAPMessageHeadler implements SOAPHandler<SOAPMessageContext> {
	
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("handleMessage invoked.");
		try {
			SOAPHeader header = context.getMessage().getSOAPPart().getEnvelope().getHeader();
		} catch (SOAPException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean handleFault(SOAPMessageContext context) {
		return false;
	}
	
	public void close(MessageContext context) {
		
	}
	
	public Set<QName> getHeaders() {
		return null;
	}
	
}
