package Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
	
	public Utilities() {
		
	}
	
	public Boolean isValidPassword(String password) {
		boolean containDigit = false;
		boolean containLowerCase = false;
		boolean containUpperCase = false;
		boolean containSpecialCharacter = false;
		for (int i = 0; password.length() > i; i++ ) {
			if (Character.isDigit(password.charAt(i)))
				containDigit = true;

			else if (Character.isLowerCase(password.charAt(i))) 
				containLowerCase = true;

			else if (Character.isUpperCase(password.charAt(i)))
				containUpperCase = true;

			else if (password.charAt(i) == '!'|| password.charAt(i) == '@'|| password.charAt(i) == '#'|| password.charAt(i) == '$'|| password.charAt(i) == '%'|| password.charAt(i) == '^'|| password.charAt(i) == '&'|| password.charAt(i) == '*'|| password.charAt(i) == '('|| password.charAt(i) == ')' || password.charAt(i) == '-' || password.charAt(i) == '+')
				containSpecialCharacter = true;
		}
	
	return (containDigit && containLowerCase && containUpperCase && containSpecialCharacter);

}
	
	public  Boolean isValidEmail(String email) {
	    // regular expression to match a valid email address
	    String regex = "^[\\w\\.-]+@[\\w\\.-]+\\.[a-z]{2,}$";
	    // compile the regex pattern
	    Pattern pattern = Pattern.compile(regex);
	    // match the pattern against the email address
	    Matcher matcher = pattern.matcher(email);
	    // return true if the email address matches the pattern, false otherwise
	    return matcher.matches();
	}

}
