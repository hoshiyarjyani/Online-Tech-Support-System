package com.dto;

/**
 * The Department class represents a department in an organization.
 * It contains the department id, name, and location information.
 * 
 * @author HoshiyarJyani
 */
public class Department {
	private int deptid;
	private String dname;
	private String location;

	public Department() {
	}

	/**
	 * Constructor for the Department class that takes in department id, name, and
	 * location as parameters.
	 * 
	 * @param deptid   The department id.
	 * @param dname    The department name.
	 * @param location The department location.
	 */
	public Department(int deptid, String dname, String location) {
		super();
		this.deptid = deptid;
		this.dname = dname;
		this.location = location;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department-ID: " + deptid + "  DepartmentName: " + dname + "  Location: " + location;
	}

}
