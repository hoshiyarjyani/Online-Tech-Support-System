package com.dto;

import java.sql.Date;

public class Complaints {

	private int complaintId;
	private int empId;
	private String complaintType;
	private int engId;
	private String status;
	private Date dateRaised;
	private Date dateResolved;

	public Complaints() {
	}

	public Complaints(int complaintId, int empId, String complaintType, int engId, String status, Date dateRaised,
			Date dateResolved) {
		super();
		this.complaintId = complaintId;
		this.empId = empId;
		this.complaintType = complaintType;
		this.engId = engId;
		this.status = status;
		this.dateRaised = dateRaised;
		this.dateResolved = dateResolved;
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

	public int getEngId() {
		return engId;
	}

	public void setEngId(int engId) {
		this.engId = engId;
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

	public Date getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Date date) {
		this.dateResolved = date;
	}

	@Override
	public String toString() {
		return "Complaint-Id : " + complaintId + "  Employee-Id: " + empId + "  Complaint-Type: " + complaintType
				+ "  Engineer-Id: " + engId + "  Status: " + status + "  DateRaised: " + dateRaised + "  DateResolved: "
				+ dateResolved;
	}

}
