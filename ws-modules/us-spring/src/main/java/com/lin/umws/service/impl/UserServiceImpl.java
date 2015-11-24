package com.lin.umws.service.impl;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.ws.WebServiceContext;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import com.lin.umws.entity.User;
import com.lin.umws.exception.UserException;
import com.lin.umws.service.ISpringService;
import com.lin.umws.service.IUserService;
import com.sun.xml.ws.api.message.Header;
import com.sun.xml.ws.api.message.HeaderList;
import com.sun.xml.ws.developer.JAXWSProperties;

/**
 * 
 * desc:   有问题-使用MTOM之后 XOP虽然有数据，但是body内依然有数据，并没有得到优化，依然存在内存溢出
 * @author xuelin
 * @date   Nov 20, 2015
 */
@WebService(endpointInterface = "com.lin.umws.service.IUserService", 
			targetNamespace = "http://service.umws.lin.com/", 
			wsdlLocation = "wsdl/user-doc.wsdl", 
			portName = "UserServicePort", serviceName = "UserService")
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private WebServiceContext cxt;
	@Resource
	private ISpringService springService;
	
	private final static Map<Integer, User> userMap = new HashMap<Integer, User>();
	
	public UserServiceImpl(){
		System.out.println("spring: " + springService);
	}
	
	static{
		User user = new User(1, "admin1", "123", 1);
		userMap.put(user.getId(), user);
	}
	
	public void add(User user) {
		System.out.println("spring: " + springService);
		userMap.put(user.getId(), user);
	}
	
	public void delete(User user) {
		userMap.remove(user.getId());
	}
	
	public List<User> list() {
		return new ArrayList<User>(userMap.values());
	}
	
	public User login(String username, String password) throws UserException {
		System.out.println("spring: " + springService);
		HeaderList headerList = (HeaderList) cxt.getMessageContext().get(JAXWSProperties.INBOUND_HEADER_LIST_PROPERTY);
		Header header = headerList.get(new QName("http://service.umws.lin.com/", "licenseType"), true);
		try {
			XMLStreamReader reader = header.readHeader();
			while(reader.hasNext()){
				int type = reader.next();
				if(type == XMLStreamReader.CHARACTERS){
					System.out.println(reader.getText());
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		
		for(User user : userMap.values()){
			if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
				return user;
			}
		}
		
		throw new UserException("用户不存在");
	}

	public void badUpload(byte[] file) {
		BufferedOutputStream bos = new BufferedOutputStream(System.out);
		try {
			bos.write(file);
			bos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void mtomUpload(byte[] mtomFile) {
		try {
			IOUtils.write(mtomFile, System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void handlerUpload(DataHandler handler) {
		DataSource dataSource = handler.getDataSource();
		System.out.println("Content-Type: " + dataSource.getContentType());
		System.out.println("Name: " + dataSource.getName());
		
		try {
			IOUtils.copy(dataSource.getInputStream(), System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
