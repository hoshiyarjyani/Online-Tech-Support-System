package com.dto;

/**
 * 
 * Represents an Engineer with their personal information such as name, ID,
 * location, and account credentials.
 * This class provides getter and setter methods to access and modify the
 * attributes of an Engineer object.
 * It also overrides the toString() method to return a string representation of
 * an Engineer object.
 * 
 * @author HoshiyarJyani
 */
public class Engineer {
	private int engId;
	private String name;
	private String userName;
	private String password;
	private String type;
	private String location;

	/**
	 * Constructs an Engineer object with default values for its attributes.
	 */
	public Engineer() {
	}

	/**
	 * Constructs an Engineer object with the specified values for its attributes.
	 * 
	 * @param engId    the ID of the Engineer
	 * @param name     the name of the Engineer
	 * @param userName the username of the Engineer's account
	 * @param password the password of the Engineer's account
	 * @param type     the type of Engineer (e.g. software engineer, mechanical
	 *                 engineer)
	 * @param location the location where the Engineer works
	 */
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
		return "EngineerId: " + engId + "  Name: " + name + "  UserName: " + userName + "  Password: " + password
				+ "  Type: " + type + "  Location: " + location;
	}

}
