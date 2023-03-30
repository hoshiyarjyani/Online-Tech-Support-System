package com.ui;

import java.util.List;

import com.dao.EngineerDAO;
import com.dao.EngineerDAOImpl;
import com.dto.Complaints;
import com.exception.ComplaintException;

public class EngineerCheckComplaintsAssigned {
	public void checkComplaintsAssigned(int engId) throws ComplaintException {

		EngineerDAO engineerDao = new EngineerDAOImpl();
		try {
			List<Complaints> complaintsAssigned = engineerDao.CheckAssignedComplaintsToEngineer(engId);
			if (complaintsAssigned.isEmpty()) {
	
				System.out.println("                                      No New Complaints Assigned                                        ");
			} else {
				complaintsAssigned.forEach(x -> System.out.println(x));
			}
		} catch (ComplaintException e) {
			  throw new ComplaintException("No Complaints Assigned.");
  
		}

	}
}
