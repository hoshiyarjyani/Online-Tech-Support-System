package com.dao;

import java.util.List;

import com.dto.Complaints;
import com.dto.Engineer;
import com.exception.ComplaintException;
import com.exception.EngineerException;

public interface EngineerDAO {

	public Engineer LogInEngineer(String username, String password) throws EngineerException, ClassNotFoundException;

	public List<Complaints> CheckAssignedComplaintsToEngineer(int engId) throws ComplaintException;

	public String UpdateComplaintStatusByEngineer(int complaintId, String newStatus, int engID)
			throws ComplaintException, ClassNotFoundException;


}
