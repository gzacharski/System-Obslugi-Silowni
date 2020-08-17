package com.myprojects.gza.myGymApp.aop;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppLoggingAspect {
	
	private Logger logger=Logger.getLogger(getClass().getName());
	
	@Before("execution(* com.myprojects.gza.myGymApp.controller.MainController.showLogIn())")
	public void beforeLogInToAccount() {
		logger.info("Just a test. Execution @Before");
	}

}
