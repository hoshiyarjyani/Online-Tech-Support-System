package com.ui;

import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.dto.HOD;
import com.exception.HODException;

public class HodLogin {
	
	public void LoginHOD() throws ClassNotFoundException {
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter Username of HOD ");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		
		HodDAO dao = new HodDAOImpl();
		
		try {
			HOD hod = dao.loginHodDAO(username, password);
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			System.out.println("                                        Welcome "+ hod.getName());
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			
		} catch (HODException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			LoginHOD();
		}
	}
}
