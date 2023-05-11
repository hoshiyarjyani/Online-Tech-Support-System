package com.ui.Engineer;

import java.util.List;

import com.dao.EngineerDAO;
import com.dao.EngineerDAOImpl;
import com.dto.Complaints;
import com.exception.ComplaintException;

/**
 * 
 * The EngineerCheckComplaintsAssigned class represents the functionality of
 * checking the complaints assigned
 * to a particular engineer. It retrieves the assigned complaints from the
 * database using the EngineerDAOImpl
 * class and prints them to the console. If there are no assigned complaints, it
 * displays a message indicating
 * that there are no new complaints assigned.
 * 
 * @author HoshiyarJyani
 */
public class EngineerCheckComplaintsAssigned {
	/**
	 * 
	 * This method retrieves a list of complaints assigned to a specific engineer
	 * and prints them to the console.
	 * If no complaints are assigned to the engineer, a message indicating this is
	 * printed instead.
	 * 
	 * @param engId the ID of the engineer whose assigned complaints should retrieved
	 * @throws ComplaintException if an error occurs while retrieving the complaints from the database
	 * @author HoshiyarJyani
	 */
	public void checkComplaintsAssigned(int engId) throws ComplaintException {

		EngineerDAO engineerDao = new EngineerDAOImpl();
		try {
			List<Complaints> complaintsAssigned = engineerDao.CheckAssignedComplaintsToEngineer(engId);
			if (complaintsAssigned.isEmpty()) {

				System.out.println(
						"                                      No New Complaints Assigned                                        ");
			} else {
				complaintsAssigned.forEach(x -> System.out.println(x));
			}
		} catch (ComplaintException e) {
			throw new ComplaintException("No Complaints Assigned.");

		}

	}
}
