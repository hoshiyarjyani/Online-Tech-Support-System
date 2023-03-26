package com.ui;

import java.util.Scanner;

public class UiMain {
		public static void main(String[] args) {
			System.out.println("Welcome to Online Hardware and Software Support System.");
			System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
			System.out.println("========Select your Option========\n");
			System.out.println("Press 1 if you are the HOD.");
			System.out.println("Press 2 if you are an Employee.");
			System.out.println("Press 3 if you are an Engineer.");
			System.out.println("Press 4 to Stop/Exit Application");
			
			Scanner sc = new Scanner(System.in);
			
			int choice = sc.nextInt();
			
			System.out.println("================================");
			
			
		}
	}


