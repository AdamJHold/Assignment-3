package com.loginconsole.adam;

import java.util.Scanner;
import java.io.IOException;

public class LoginConsole {
	
	private static final int MAX_ATTEMPTS = 5;
	public static UserService userService = new UserService();
	
	public static void main (String[] args) throws IOException {
		
		Scanner input = null;
		String username;
		String password;
		int attempts = 1;
		
		userService.readUsers("data.txt");
		
		try {
			
			input = new Scanner(System.in);
			boolean validInput = false;
			while (validInput != true) {
				System.out.println("Enter Username: ");
				username = input.next();
				System.out.println("Enter Password: ");
				password = input.next();
				
				User found = userService.userFound(username, password);
				if (found != null) {
					System.out.println("Welcome: " + found.getName());
					validInput = true;
				break;
				} if (attempts < MAX_ATTEMPTS) {
					System.out.println("Invalid entry, please try again!");
					attempts++;
				} else {
					System.out.println("Too many failed attempts, you are now locked out!");
				break;	
				}
			}
		} 
		finally {
			input.close();
		}
	}
}