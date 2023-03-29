package com.ui;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dao.EngineerDAO;
import com.dao.EngineerDAOImpl;
import com.exception.EngineerException;

public class EngineerChangePassword {
	public void EngineerPasswordChange() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Username");
		String userName = sc.next();
		System.out.println("Enter Your Old Password");
		String oldPassword = sc.next();
		System.out.println("Enter New Password to be set.\nNote- Password should have 8 to 20 Characters.\nNo Space,Include Atleast 1 Digit, 1 Uppercase, 1 Lowercase and a Special Character.");
		String newPassword = sc.next();
		
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
		
		Pattern p = Pattern.compile(regex);
		
		Matcher m = p.matcher(newPassword);
		
		if(m.matches()) {
			EngineerDAO engineerDao = new EngineerDAOImpl();
			
			try {
				String result = engineerDao.ChangeEngineerNewPassword(userName, oldPassword, newPassword);
				System.out.println(result);
			} catch (EngineerException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("Oops! Try Again.\nEnter New Password to be set.\nNote- Password should have 8 to 20 Characters.\nNo Space,Include Atleast 1 Digit, 1 Uppercase, 1 Lowercase and a Special Character.");
			EngineerPasswordChange();	
		}
	}
}
