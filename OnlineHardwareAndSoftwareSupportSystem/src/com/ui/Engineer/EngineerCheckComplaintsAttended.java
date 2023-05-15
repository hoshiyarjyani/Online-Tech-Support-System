package com.ui.Engineer;

import java.util.List;

import com.dao.EngineerDAO;
import com.dao.EngineerDAOImpl;
import com.dto.Complaints;
import com.exception.ComplaintException;
import com.exception.NoRecordFoundException;

/**
 * 
 * This class is responsible for providing the functionality to the engineer to
 * check the complaints that he/she has attended to. The class has a method
 * named CheckComplaintsAttended, which takes an integer engineer ID as input
 * and returns a list of Complaints
 * attended by the engineer
 * from the database using EngineerDAOImpl object. If the list is empty, then it
 * prints a message
 * "No Complaints Attended By Engineer." Otherwise, it prints the complaints
 * attended by the engineer.
 * 
 * @author HoshiyarJyani
 */
public class EngineerCheckComplaintsAttended {
	/**
	 * This method takes an integer engineer ID as input and returns a list of
	 * Complaints
	 * attended by the engineer from the database using EngineerDAOImpl object. If
	 * the list
	 * is empty, then it prints a message "No Complaints Attended By Engineer."
	 * Otherwise,
	 * it prints the complaints attended by the engineer.
	 * 
	 * @param engId the integer ID of the engineer
	 * @throws ClassNotFoundException if the class is not found
	 * @author HoshiyarJyani
	 */
	public void CheckComplaintsAttended(int engId) throws ClassNotFoundException {
		EngineerDAO engineerDao = new EngineerDAOImpl();

		try {
			List<Complaints> list = engineerDao.CheckComplaintsAttendedByEngineer(engId);
			if (list.isEmpty()) {
				System.out.println(
						"                               No Complaints Attended By Engineer                                       ");
			} else {
				list.forEach(x -> System.out.println(x));
			}
		} catch (ComplaintException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}