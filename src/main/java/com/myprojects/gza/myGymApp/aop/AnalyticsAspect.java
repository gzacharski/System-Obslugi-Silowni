package com.myprojects.gza.myGymApp.aop;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.myprojects.gza.myGymApp.entity.Page;
import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.entity.UserTimestamp;
import com.myprojects.gza.myGymApp.helperClasses.UserAction;
import com.myprojects.gza.myGymApp.service.PageService;
import com.myprojects.gza.myGymApp.service.UserAnalyticsService;
import com.myprojects.gza.myGymApp.service.UserService;

@Aspect
@Component
public class AnalyticsAspect {
	
	@Autowired
	private PageService pageService;
	
	@Autowired
	private UserAnalyticsService userAnalyticsService;
	
	@Autowired
	private UserService userService;
	
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
