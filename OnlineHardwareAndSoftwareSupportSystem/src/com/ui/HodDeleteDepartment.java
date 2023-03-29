package com.ui;

import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.exception.DepartmentException;


public class HodDeleteDepartment {
	public void hodDeleteDepartment() throws ClassNotFoundException {
		System.out.println("Delete Department");
		System.out.println("=======================================");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name of Department That You Wants to Delete From Database");
		String dname = sc.next();
		System.out.println("=======================================");
		HodDAO hoddao = new HodDAOImpl();
		
		try {
			String result = hoddao.DeleteDepartmentByHOD(dname);
			System.out.println(result);
		} catch (DepartmentException e) {
			System.out.println(e.getMessage());
		}
	}
}
