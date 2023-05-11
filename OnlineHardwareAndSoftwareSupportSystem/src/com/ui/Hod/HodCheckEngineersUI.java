package com.ui.Hod;

import java.util.List;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.dto.Engineer;
import com.exception.EngineerException;
import com.exception.NoRecordFoundException;

/**
 * 
 * This class is responsible for displaying the list of engineers to the HOD.
 * The class calls the getEngineers() method from the HodDAOImpl class to
 * retrieve the list of engineers
 * and displays it to the console.
 * 
 * @author HoshiyarJyani
 */
public class HodCheckEngineersUI {
	/**
	 * This method calls the getEngineers() method from HodDAOImpl to retrieve the
	 * list of engineers
	 * and displays it to the console.
	 * @author HoshiyarJyani
	 * @throws ClassNotFoundException
	 * @throws NoRecordFoundException
	 */
	public void hodCheckEngineers() throws ClassNotFoundException, NoRecordFoundException {
		HodDAO dao = new HodDAOImpl();

		try {
			List<Engineer> engs = dao.getEngineers();
			engs.forEach(eng -> System.out.println(eng));

		} catch (EngineerException e) {
			System.out.println(e.getMessage());
		}
	}
}