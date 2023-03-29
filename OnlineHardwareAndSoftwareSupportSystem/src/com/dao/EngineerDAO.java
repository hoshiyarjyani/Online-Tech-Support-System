package com.dao;

import com.dto.Engineer;
import com.exception.EngineerException;

public interface EngineerDAO {

	public Engineer LogInEngineer(String username, String password) throws EngineerException, ClassNotFoundException;

}
