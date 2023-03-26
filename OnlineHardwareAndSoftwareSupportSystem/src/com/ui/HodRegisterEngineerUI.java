package com.ui;

import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.exception.EngineerException;

public class HodRegisterEngineerUI {
	
	public void hodRegisterEngineer() throws ClassNotFoundException {
		String res = "Entries are Invalid, Please Write Carefully! Try again.";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Engineer Name");
		String name = sc.next();
		System.out.println("Enter Engineer's Username");
		String username = sc.next();
		System.out.println("Enter Engineer's Password");
		String password = sc.next();
		
		System.out.println("Press 1. for Hardware Engineer");
		System.out.println("Press 2. for Software Engineer");
		int typeChoice = sc.nextInt();
		
		String type = "";
		
		if(typeChoice==1) {
			type = "Hardware Engineer";
		}else if(typeChoice==2) {
			type = "Software Engineer";
		}else {
			System.out.println("Invalid Choice. Please Try Again.");
			hodRegisterEngineer();
		}
		
		System.out.println("Enter Engineer's Location");
		String location = sc.next();
		
		System.out.println("==============================================");
		
		HodDAO dao = new HodDAOImpl();
		
		try {
			res = dao.registerEngineer(name, username, password, type, location);
			System.out.println(res);
			System.out.println("====================================");
		} catch (EngineerException e) {
			System.out.println(e.getMessage());
			System.out.println("=============================================");
			hodRegisterEngineer();
		}
	}
}