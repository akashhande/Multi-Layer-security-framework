package com.src.bo;

import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class ServiceValidator {

	private static final String SECURITY_PATTERN = "[a-zA-Z0-9~@#$^*()_+=]*";
	private static final List<String> maliciousScript = Arrays.asList("WHERE", "OR", 
			"HAVING", "NOT", "ORDER BY", "GROUP BY", "AND", "SLEEP");

	public boolean validate(final String validationString) {
		Pattern pattern = Pattern.compile(SECURITY_PATTERN);
		Matcher matcher = pattern.matcher(validationString);
		return matcher.matches() && !maliciousScript.contains(validationString);
	}
}
