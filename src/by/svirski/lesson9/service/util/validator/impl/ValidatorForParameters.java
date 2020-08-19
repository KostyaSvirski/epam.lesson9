package by.svirski.lesson9.service.util.validator.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.svirski.lesson9.service.util.validator.CustomValidator;

public class ValidatorForParameters implements CustomValidator {

	private final String correctFormatRegex = "^[ \\p{Punct}\\p{Blank}0-9a-zA-Z]{0,256}=[\\p{Punct}\\p{Blank}0-9a-zA-Z]{0,256}$";

	public ValidatorForParameters() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validate(String[] parametersToCheck) {
		if (parametersToCheck.length == 1 && parametersToCheck[0].isBlank()) {
			return true;
		}
		Pattern pattern = Pattern.compile(correctFormatRegex);
		for (String parameter : parametersToCheck) {
			Matcher matcher = pattern.matcher(parameter);
			if (!matcher.matches()) {
				return false;
			}
		}
		return true;
	}

}
