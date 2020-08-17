package com.myprojects.gza.myGymApp.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
@Retention(RUNTIME)
@Target({ TYPE, ANNOTATION_TYPE })
public @interface FieldMatch {
	String message() default "";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	String firstField();
	
	String secondField();
	
	@Target({TYPE,ANNOTATION_TYPE})
	@Retention(RUNTIME)
	@Documented
	@interface List{
		FieldMatch[] value();
	}
}
