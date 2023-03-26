package com.dao;

import com.dto.HOD;
import com.exception.EngineerException;
import com.exception.HODException;

public interface HodDAO {
	
	public HOD loginHodDAO(String username, String password) throws HODException, ClassNotFoundException;
	public String registerEngineer(String name, String username, String password, String type, String location) throws EngineerException, ClassNotFoundException;
}