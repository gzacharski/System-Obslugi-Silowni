package com.myprojects.gza.myGymApp.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelephoneNumberValidator implements ConstraintValidator<ValidTelephoneNumber, String>{
	
	private Pattern pattern;
	private Matcher matcher;
	private static final String TELEPHONE_NUMBER_PATTERN="^[0-9]{9}";
	
	@Override
	public boolean isValid(String telephoneNumber, ConstraintValidatorContext context) {

		pattern=Pattern.compile(TELEPHONE_NUMBER_PATTERN);
		
		if(telephoneNumber==null || telephoneNumber.trim().length()==0) {
			return true;
		}
		
		matcher=pattern.matcher(telephoneNumber);
		
		return matcher.matches();
	}

}
