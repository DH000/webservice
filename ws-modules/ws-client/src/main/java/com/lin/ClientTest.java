package com.lin;

public class ClientTest {
	public static void main(String[] args) {
		try {
			MyService myService = new MyServiceImplService().getMyServiceImplPort();
			myService.login("admin1", "123");
		} catch (Exception_Exception e) {
			e.printStackTrace();
		}
	}
}
