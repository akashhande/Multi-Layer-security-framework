package com.src.bo;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
//	[A-Za-z@$£0-9]{6}
	private static final String SECURITY_PATTERN = "[a-zA-Z0-9~@#$^*()_+=]*";
	private static final List<String> maliciousScript = Arrays.asList("WHERE", "OR", "HAVING", "NOT", "ORDER BY", "GROUP BY", "AND", "SLEEP");

	public static boolean validate(final String validationString) {
		Pattern pattern = Pattern.compile(SECURITY_PATTERN);
		Matcher matcher = pattern.matcher(validationString);
		return matcher.matches() && !maliciousScript.contains(validationString);
	}
	
	public static void main(String[] args) {
		System.out.println("test - "+validate("Akash@1"));
	}

}
