package com.dao;

import java.util.List;

import com.dto.Complaints;
import com.dto.Engineer;
import com.exception.ComplaintException;
import com.exception.EngineerException;
import com.exception.NoRecordFoundException;

/**
 * 
 * The EngineerDAO interface provides methods to access and manipulate the data
 * related to the Engineer entity
 * in the system. This includes logging in the engineer, checking assigned
 * complaints, updating complaint status,
 * checking attended complaints, and changing password for the engineer.
 * 
 * @author HoshiyarJyani
 */
public interface EngineerDAO {
	/**
	 * Logs in the engineer with the given username and password.
	 * 
	 * @param username The username of the engineer to log in.
	 * @param password The password of the engineer to log in.
	 * @return The Engineer object if the login is successful, null otherwise.
	 * @throws EngineerException      if there is an error while accessing the data.
	 * @throws ClassNotFoundException if the JDBC driver is not found.
	 */
	public Engineer LogInEngineer(String username, String password) throws EngineerException, ClassNotFoundException;

	/**
	 * Returns the list of complaints assigned to the engineer with the given ID.
	 * 
	 * @param engId The ID of the engineer.
	 * @return The list of Complaint objects assigned to the engineer.
	 * @throws ComplaintException if there is an error while accessing the data.
	 */
	public List<Complaints> CheckAssignedComplaintsToEngineer(int engId) throws ComplaintException;

	/**
	 * Updates the status of the complaint with the given ID and assigns it to the
	 * engineer with the given ID.
	 * 
	 * @param complaintId The ID of the complaint to update.
	 * @param newStatus   The new status of the complaint.
	 * @param engID       The ID of the engineer to assign the complaint to.
	 * @return The string "success" if the update is successful.
	 * @throws ComplaintException     if there is an error while accessing the data.
	 * @throws ClassNotFoundException if the JDBC driver is not found.
	 */
	public String UpdateComplaintStatusByEngineer(int complaintId, String newStatus, int engID)
			throws ComplaintException, ClassNotFoundException;

	/**
	 * Returns the list of complaints attended by the engineer with the given ID.
	 * 
	 * @param engId The ID of the engineer.
	 * @return The list of Complaint objects attended by the engineer.
	 * @throws ComplaintException     if there is an error while accessing the data.
	 * @throws ClassNotFoundException if the JDBC driver is not found.
	 * @throws NoRecordFoundException if there are no complaints attended by the
	 *                                engineer.
	 */
	public List<Complaints> CheckComplaintsAttendedByEngineer(int engId)
			throws ComplaintException, ClassNotFoundException, NoRecordFoundException;

	/**
	 * Changes the password of the engineer with the given username and old
	 * password.
	 * 
	 * @param userName    The username of the engineer.
	 * @param oldPassword The old password of the engineer.
	 * @param newPassword The new password to set.
	 * @return The string "success" if the password is changed successfully.
	 * @throws EngineerException      if there is an error while accessing the data.
	 * @throws ClassNotFoundException if the JDBC driver is not found.
	 */
	public String ChangeEngineerNewPassword(String userName, String oldPassword, String newPassword)
			throws EngineerException, ClassNotFoundException;

}
