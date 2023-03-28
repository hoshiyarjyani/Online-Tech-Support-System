package com.ui;

import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.exception.EngineerException;

public class HodDeleteEngineer {

	public void hodDeleteEngineer() throws ClassNotFoundException {
		System.out.println("Delete Engineer");
		System.out.println("=======================================");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID of Engineer That You Wants to Delete From Database");
		int engId = sc.nextInt();
		System.out.println("=======================================");
		HodDAO hoddao = new HodDAOImpl();
		
		try {
			String res = hoddao.DeleteEngineerByHodDAO(engId);
			System.out.println(res);
		} catch (EngineerException e) {
			System.out.println(e.getMessage());
		}
	}
}