package com.book.security;

public class PasswordManager {
	
	    public static String encryptPassword(String password , int shift) {
	        StringBuilder encryptedPassword = new StringBuilder();

	        for (int i = 0; i < password.length(); i++) {
	            char ch = password.charAt(i);
	            if (Character.isUpperCase(ch)) {
	                char encryptedChar = (char) ((ch + shift - 'A') % 26 + 'A');
	                encryptedPassword.append(encryptedChar);
	            }

	            else if (Character.isLowerCase(ch)) {
	                char encryptedChar = (char) ((ch + shift - 'a') % 26 + 'a');
	                encryptedPassword.append(encryptedChar);
	            }

	            else {
	                encryptedPassword.append(ch);
	            }
	        }

	        return encryptedPassword.toString();
	    }

	    public static String decryptPassword(String encryptedPassword) {
	        StringBuilder decryptedPassword = new StringBuilder();
	        int shift = 3;
	        for (int i = 0; i < encryptedPassword.length(); i++) {
	            char ch = encryptedPassword.charAt(i);
	            if (Character.isUpperCase(ch)) {
	                char decryptedChar = (char) ((ch - shift - 'A' + 26) % 26 + 'A');
	                decryptedPassword.append(decryptedChar);
	            }
	            else if (Character.isLowerCase(ch)) {
	                char decryptedChar = (char) ((ch - shift - 'a' + 26) % 26 + 'a');
	                decryptedPassword.append(decryptedChar);
	            }
	            else {
	                decryptedPassword.append(ch);
	            }
	        }
	        return decryptedPassword.toString();
	    }
}
