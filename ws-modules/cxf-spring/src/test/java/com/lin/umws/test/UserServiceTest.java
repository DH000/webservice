package com.lin.umws.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lin.umws.service.client.IUserService;
import com.lin.umws.service.client.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {
	@Resource
	private IUserService userService;
	
	@Test
	public void addTest(){
		userService.add(new User(1, "admin1", "123", 2));
	}
	
}
