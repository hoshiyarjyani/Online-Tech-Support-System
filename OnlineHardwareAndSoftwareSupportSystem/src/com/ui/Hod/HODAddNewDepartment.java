package com.ui.Hod;

import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.exception.DepartmentException;

public class HODAddNewDepartment {
	public void HodRegisterDepartment() throws ClassNotFoundException {
		String result = "Entries are Invalid, Please Write Carefully! Try again.";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department Name");
		String dname = sc.next();
		System.out.println("Enter Department City");
		String city = sc.next();
		
		HodDAO dao = new HodDAOImpl();
		
		try {
			result = dao.RegisterDepartment(dname,city);
			System.out.println(result);
		} catch (DepartmentException e) {
			System.out.println(e.getMessage());
			HodRegisterDepartment();
		}
	}
}
