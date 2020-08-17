package com.myprojects.gza.myGymApp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

	@Pointcut("execution(* com.myprojects.gza.myGymApp.controller.MainController.*(..))")
	protected void forMainControllerInControllerPakage() {}
}
