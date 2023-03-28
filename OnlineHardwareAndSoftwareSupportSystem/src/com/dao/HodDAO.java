package com.dao;

import java.util.List;

import com.dto.Complaints;
import com.dto.Engineer;
import com.dto.HOD;
import com.exception.ComplaintException;
import com.exception.EngineerException;
import com.exception.HODException;
import com.exception.NoRecordFoundException;

public interface HodDAO {
	
	public HOD loginHodDAO(String username, String password) throws HODException, ClassNotFoundException;
	public String registerEngineer(String name, String username, String password, String type, String location) throws EngineerException, ClassNotFoundException;
	public List<Engineer> getEngineers() throws EngineerException, ClassNotFoundException, NoRecordFoundException;
	public String DeleteEngineerByHodDAO(int engId) throws EngineerException, ClassNotFoundException;
	public List<Complaints> CheckComplaintsByHodDAO() throws ComplaintException, ClassNotFoundException, NoRecordFoundException;
}