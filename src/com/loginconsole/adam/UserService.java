package com.loginconsole.adam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserService {
	
	public User[] loginUsers = new User[4];
	
	public User userFound(String username, String password) {
		
		for (User user : loginUsers) {

			if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
					return user;
			}
		}
		return null;
	}
	
	public void readUsers(String fileName) throws IOException {
		fileName = "data.txt";
		BufferedReader reader = null;
		String currLine;
		int line = 0;
		
		try {
			reader = new BufferedReader(new FileReader(fileName));
			while ((currLine = reader.readLine()) != null) {
				loginUsers[line] = new User(currLine.split(","));
				line++;
			}
			
		}  finally {
			if (reader != null)
			  reader.close();
		}
	}
}