package com.dto;

public class Engineer {
	private int engId;
	private String name;
	private String userName;
	private String password;
	private String type;
	private String location;
	
	public Engineer() {}

	public Engineer(int engId, String name, String userName, String password, String type, String location) {
		this.engId = engId;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.location = location;
	}

	public int getEngId() {
		return engId;
	}

	public void setEngId(int engId) {
		this.engId = engId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Engineer [Engineer Id=" + engId + ", Name=" + name + ", UserName=" + userName + ", Password=" + password
				+ ", Type=" + type + ", Location=" + location + "]";
	}
	
	
}
