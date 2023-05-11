package com.dto;

import java.sql.Date;

/**
 * 
 * The Complaints class represents a complaint made by an employee against a
 * service provided by an engineer.
 * Each complaint has a unique complaint ID, an ID of the employee who raised
 * the complaint, the type of complaint,
 * the ID of the engineer who is assigned to resolve the complaint, the status
 * of the complaint, and the dates
 * on which the complaint was raised and resolved.
 * 
 * @author HoshiyarJyani
 */
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

	/**
	 * Constructs a new Complaints object with the specified values for all instance
	 * variables.
	 * 
	 * @param complaintId   The unique ID of the complaint.
	 * @param empId         The ID of the employee who raised the complaint.
	 * @param complaintType The type of the complaint.
	 * @param engId         The ID of the engineer who is assigned to resolve the
	 *                      complaint.
	 * @param status        The status of the complaint.
	 * @param dateRaised    The date on which the complaint was raised.
	 * @param dateResolved  The date on which the complaint was resolved.
	 */
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
