package com.dao;

import com.dto.HOD;
import com.exception.HODException;

public interface HodDAO {
	
	public HOD loginHodDAO(String username, String password) throws HODException, ClassNotFoundException;
	
}