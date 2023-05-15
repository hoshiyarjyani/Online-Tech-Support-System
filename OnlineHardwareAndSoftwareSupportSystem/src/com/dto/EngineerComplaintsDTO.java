package com.dto;

import java.sql.Date;

/**
 * 
 * This class represents an Engineer Complaint DTO (Data Transfer Object) which
 * contains the data related to a complaint
 * filed by an engineer. It contains various fields such as Engineer ID, name,
 * username, password, complaint ID,
 * complaint type, status, etc. which are required to maintain the complaint
 * details of an engineer. The class provides
 * getter and setter methods for all its fields to get and set the values of the
 * fields. It also contains a toString()
 * method to return a string representation of the object. This DTO is used to
 * transfer the data related to engineer
 * complaints between different layers of the application such as the service
 * layer and the presentation layer.
 * 
 * @author HoshiyarJyani
 */
public class EngineerComplaintsDTO {

	private int engId;
	private String name;
	private String userName;
	private String password;
	private String type;
	private String location;
	private int complaintId;
	private int empId;
	private String complaintType;
	private String status;
	private Date dateRaised;
	private String dateResolved;

	public EngineerComplaintsDTO() {
	}

	public EngineerComplaintsDTO(int engId, String name, String userName, String password, String type, String location,
			int complaintId, int empId, String complaintType, String status, Date dateRaised, String dateResolved) {
		super();
		this.engId = engId;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.location = location;
		this.complaintId = complaintId;
		this.empId = empId;
		this.complaintType = complaintType;
		this.status = status;
		this.dateRaised = dateRaised;
		this.dateResolved = dateResolved;
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

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateRaised() {
		return dateRaised;
	}

	public void setDateRaised(Date date) {
		this.dateRaised = date;
	}

	public String getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(String dateResolved) {
		this.dateResolved = dateResolved;
	}

	@Override
	public String toString() {
		return "Engineer-ID: " + engId + "  Name: " + name + "  UserName: " + userName + "  Password: "
				+ password + "  Type: " + type + "  Location: " + location + ", ComplaintId: " + complaintId
				+ "  Employee-Id: "
				+ empId + "  ComplaintType: " + complaintType + "  Status: " + status + "  DateRaised: " + dateRaised
				+ "  DateResolved: " + dateResolved;
	}

}
