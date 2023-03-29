package com.ui;

import java.util.Scanner;

import com.dao.EngineerDAO;
import com.dao.EngineerDAOImpl;
import com.dto.Engineer;
import com.exception.EngineerException;

public class EngineerLogIn {
	public int engineerLogin() throws ClassNotFoundException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		System.out.println("===================================");

		EngineerDAO engineerDao = new EngineerDAOImpl();
		int engineerId = 0;

		try {
			Engineer engineer = engineerDao.LogInEngineer(username, password);
			System.out.println("Welcome " + engineer.getName());
			engineerId = engineer.getEngId();
		} catch (EngineerException e) {
			System.out.println(e.getMessage());
			engineerLogin();
		}
		return engineerId;
	}
}
