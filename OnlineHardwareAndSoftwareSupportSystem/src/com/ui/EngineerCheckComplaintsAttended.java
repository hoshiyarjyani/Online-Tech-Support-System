package com.ui;

import java.util.List;

import com.dao.EngineerDAO;
import com.dao.EngineerDAOImpl;
import com.dto.Complaints;
import com.exception.ComplaintException;
import com.exception.NoRecordFoundException;

public class EngineerCheckComplaintsAttended {

	public void CheckComplaintsAttended(int engId) throws ClassNotFoundException, NoRecordFoundException {
		EngineerDAO engineerDao = new EngineerDAOImpl();
		
		try {
			List<Complaints> list = engineerDao.CheckComplaintsAttendedByEngineer(engId);
			if(list.isEmpty()) {
				System.out.println("No Complaints Attended By Engineer.");
			}else {
				list.forEach(x -> System.out.println(x));
			}
		} catch (ComplaintException e) {
			e.printStackTrace();
		}
	}
}