package com.lin.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.MTOMFeature;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.lin.umws.service.IUserService;
import com.lin.umws.service.UserService;

public class UserServiceTest {
	@Test
	public void badUploadTest() {
		try {
			UserService userService = new UserService(new URL("http://localhost:8888/us"), new QName("http://service.umws.lin.com/", "UserService", "ns"));
			IUserService port = userService.getUserServicePort();
			
			InputStream is = this.getClass().getResourceAsStream("UserServiceTest.class");
			byte[] file = new byte[is.available()];
			is.read(file);
			port.badUpload(file);
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void mtomUploadTest(){
		try {
			UserService userService = new UserService(new URL("http://localhost:8888/us"), new QName("http://service.umws.lin.com/", "UserService", "ns"));
//			IUserService port = userService.getUserServicePort(new MTOMFeature());
			IUserService port = userService.getUserServicePort();
			
			BindingProvider bp = (BindingProvider)port;
		    SOAPBinding binding = (SOAPBinding)bp.getBinding();
		    binding.setMTOMEnabled(true);
			
			InputStream is = this.getClass().getResourceAsStream("UserServiceTest.class");
			byte[] file = IOUtils.toByteArray(is);
			port.mtomUpload(file);
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void handlerUploadTest(){
		try {
			UserService userService = new UserService(new URL("http://localhost:8888/us"), new QName("http://service.umws.lin.com/", "UserService", "ns"));
			IUserService port = userService.getUserServicePort(new MTOMFeature());
			InputStream is = this.getClass().getResourceAsStream("UserServiceTest.class");
			DataHandler handlerFile = new DataHandler(new DataSource() {
				
				public OutputStream getOutputStream() throws IOException {
					return null;
				}
				
				public String getName() {
					return "UserServiceTest.class";
				}
				
				public InputStream getInputStream() throws IOException {
					return this.getClass().getResourceAsStream(getName());
				}
				
				public String getContentType() {
					return "application/octet-stream";
				}
			});
			port.handlerUpload(handlerFile);
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
