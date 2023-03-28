package com.ui;

import java.util.List;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.dto.Engineer;
import com.exception.EngineerException;
import com.exception.NoRecordFoundException;

public class HodCheckEngineersUI {

	public void hodCheckEngineers() throws ClassNotFoundException, NoRecordFoundException {
		HodDAO dao = new HodDAOImpl();
		
		try {
			List<Engineer> engs = dao.getEngineers();
			engs.forEach(eng -> System.out.println(eng));
			System.out.println("===============================");
			
		} catch (EngineerException e) {
			System.out.println(e.getMessage());
		}
	}
}