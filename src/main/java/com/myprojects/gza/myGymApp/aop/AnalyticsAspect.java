package com.myprojects.gza.myGymApp.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myprojects.gza.myGymApp.entity.Page;
import com.myprojects.gza.myGymApp.service.PageService;

@Aspect
@Component
public class AnalyticsAspect {
	
	@Autowired
	private PageService pageService;
	
	private Logger logger=Logger.getLogger(getClass().getName());
	
	@Before("com.myprojects.gza.myGymApp.aop.AOPExpressions.forMainControllerInControllerPakage()")
	public void countPageViews(JoinPoint theJoinPoint) {
		logger.info("Executing Analytics: ");
		
		MethodSignature methodSignature=(MethodSignature) theJoinPoint.getSignature();
		
		logger.info(methodSignature.toShortString());
		
		refreshStatistics(methodSignature);
	}

	private void refreshStatistics(MethodSignature methodSignature) {
		String page=methodSignature.toShortString();
		
		logger.info("Method signature: "+ page+ " new entry for statistics ");
		
		Page tempPage=new Page(page);
		
		pageService.saveOrUpdate(tempPage);
	}
	
	
}
