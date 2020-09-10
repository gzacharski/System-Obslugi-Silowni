package com.myprojects.gza.myGymApp.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ImageFileExtensionValidator implements ConstraintValidator<AcceptableiImageFileExtension, String>{
	
	private Pattern pattern;
	private Matcher matcher;
	private static final String IMAGE_FILE_EXTENSION_PATTERN="[A-Za-z0-9-_]{1,42}\\.(png|jpe?g)";
	
	@Override
	public boolean isValid(final String imageName, final ConstraintValidatorContext context) {
		
		pattern=Pattern.compile(IMAGE_FILE_EXTENSION_PATTERN);
		
		if(imageName==null) {
			return false;
		}
		
		matcher=pattern.matcher(imageName);
		
		return matcher.matches();
	}

}
