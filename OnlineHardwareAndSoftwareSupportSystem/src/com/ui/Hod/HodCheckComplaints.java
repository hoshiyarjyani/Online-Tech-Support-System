package com.ui.Hod;

import java.util.List;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.dto.Complaints;
import com.exception.NoRecordFoundException;

/**
 * 
 * This class represents the user interface for the HOD to check all the
 * complaints that have been raised.
 * It uses the HodDAOImpl class to get the list of complaints from the database
 * and displays them on the console.
 * If there are no complaints, it displays a message saying "No complaints have
 * been raised."
 * If an error occurs, it displays an error message on the console.
 * 
 * @author HoshiyarJyani
 */
public class HodCheckComplaints {
	/**
	 * This method retrieves the list of complaints from the database and displays
	 * them on the console.
	 * If there are no complaints, it displays a message saying "No complaints have
	 * been raised."
	 * If an error occurs, it displays an error message on the console.
	 * 
	 * @author HoshiyarJyani
	 */
	public void CheckAllComplaintsByHOD() {
		try {
			HodDAO dao = new HodDAOImpl();
			List<Complaints> list = dao.CheckComplaintsByHodDAO();
			for (Complaints c : list) {
				System.out.println(c);
			}
		} catch (NoRecordFoundException e) {
			System.out.println("No complaints have been raised.");
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

}
