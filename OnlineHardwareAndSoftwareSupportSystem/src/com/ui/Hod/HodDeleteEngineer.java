package com.ui.Hod;

import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;
import com.exception.EngineerException;

public class HodDeleteEngineer {

	public void hodDeleteEngineer() throws ClassNotFoundException {
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                          Delete Engineer                                             |");
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("|                     Enter the ID of Engineer That You Wants to Delete From Database                  |");
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		
		int engId = sc.nextInt();
		HodDAO hoddao = new HodDAOImpl();
		
		try {
			String res = hoddao.DeleteEngineerByHodDAO(engId);
			System.out.println(res);
		} catch (EngineerException e) {
			System.out.println(e.getMessage());
		}
	}
}