package com.lin.umws.handler;

import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SOAPMessageHeadler implements SOAPHandler<SOAPMessageContext> {
	
	public void close(MessageContext context) {
	}
	
	public boolean handleFault(SOAPMessageContext arg0) {
		return false;
	}
	
	public boolean handleMessage(SOAPMessageContext context) {
		try {
			if(!(Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)){
				System.out.println("----------------------------------------request---------------------------------------");
				context.getMessage().writeTo(System.out);
				System.out.println();
				System.out.println("----------------------------------------end request---------------------------------------");
			}
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public Set<QName> getHeaders() {
		return null;
	}
	
}
