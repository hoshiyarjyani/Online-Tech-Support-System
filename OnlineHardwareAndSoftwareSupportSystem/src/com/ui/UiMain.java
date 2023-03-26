package com.ui;

import java.util.Scanner;

import com.dao.HodDAO;
import com.dao.HodDAOImpl;

public class UiMain {
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Welcome to Online Hardware and Software Support System. ");
		System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		System.out.println("========Select your Option========\n");
		System.out.println("Press 1 if you are the HOD.");
		System.out.println("Press 2 if you are an Employee.");
		System.out.println("Press 3 if you are an Engineer.");
		System.out.println("Press 4 if you want Stop/Exit Application");

		Scanner sc = new Scanner(System.in);

		int choice = sc.nextInt();

		System.out.println("================================");

		switch (choice) {

		case 1:
			System.out.println("HOD");
			System.out.println("=============================");
			HodLogin login = new HodLogin();
			login.LoginHOD();
          break;

		case 2:
			while (true) {
				System.out.println("Employee.");
				System.out.println("==================================================");
				System.out.println("Enter 1 to login if you are already registered.");
				System.out.println("Enter 2 to register to the system if you are a new employee.");
				System.out.println("Enter 3 to exit.");

			}
		case 3:
			System.out.println("System Engineer");
			System.out.println("==================================================");

			
			System.out.println("=================================================");

			while (true) {

			}

		case 4:
			System.out.println("Thank you.");
			System.exit(0);

		}
	}
}
