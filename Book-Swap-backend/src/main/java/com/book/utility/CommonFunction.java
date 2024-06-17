package com.book.utility;

import com.book.user.entity.SaveUserData;

import jakarta.persistence.GeneratedValue;

public class  CommonFunction {
	
	
	public static String generateUserName(String fullName, String dob) {
	    String firstName = fullName.substring(0, Math.min(fullName.length(), 4));
	    String yearDigits = dob.substring(dob.length() - 2);
	    String userId = firstName + yearDigits;
	    return userId;
	}
	public static String generatePassword(String fullName, String dob) {
	   
	    String lastName = fullName.substring(Math.max(0, fullName.length() - 4));
	    String month = dob.substring(5, 7); 
	    String password = lastName + month;
	    return password;
	}
	public static String generateFullName(SaveUserData user)
	{
		String FullName = user.getFirstName()+" "+user.getLastName();
		return FullName;
	}



}
