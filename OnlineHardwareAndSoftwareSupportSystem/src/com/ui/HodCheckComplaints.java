package com.ui;

import java.util.List;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.dto.Complaints;
import com.exception.NoRecordFoundException;

public class HodCheckComplaints {

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
