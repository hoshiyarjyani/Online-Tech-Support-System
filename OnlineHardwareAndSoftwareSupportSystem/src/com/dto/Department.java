package com.dto;

public class Department {
private int deptid;
private String dname;
private String location;


public Department() {}

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
