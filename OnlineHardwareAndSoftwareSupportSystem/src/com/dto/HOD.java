package com.dto;

/**
 * 
 * The HOD class represents the Head of Department in an organization.
 * This class is a DTO (Data Transfer Object) that holds the HOD's details such
 * as their ID, name, username, and password.
 * 
 * @author HoshiyarJyani
 */
public class HOD {
	private int hodId;
	private String name;
	private String userName;
	private String password;

	public HOD() {
	}

	public HOD(int hodId, String name, String userName, String password) {
		this.hodId = hodId;
		this.name = name;
		this.userName = userName;
		this.password = password;
	}

	public int getHodId() {
		return hodId;
	}

	public void setHodId(int hodId) {
		this.hodId = hodId;
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

	@Override
	public String toString() {
		return "Hod [hodId=" + hodId + ", name=" + name + ", userName=" + userName + ", password=" + password + "]";
	}

}
