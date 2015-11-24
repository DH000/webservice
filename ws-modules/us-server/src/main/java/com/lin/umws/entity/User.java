package com.lin.umws.entity;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * desc: TODO
	 */
	private static final long serialVersionUID = -9157972235465925678L;
	
	private Integer id;
	private String username;
	private String password;
	private Integer sex;
	
	public User() {
		super();
	}

	public User(Integer id, String username, String password, Integer sex) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getSex() {
		return sex;
	}
	
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + "]";
	}
	
}
