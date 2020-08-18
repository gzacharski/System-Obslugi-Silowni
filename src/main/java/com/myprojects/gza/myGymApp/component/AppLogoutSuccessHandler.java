package com.myprojects.gza.myGymApp.component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.entity.UserTimestamp;
import com.myprojects.gza.myGymApp.helperClasses.UserAction;
import com.myprojects.gza.myGymApp.service.UserAnalyticsService;
import com.myprojects.gza.myGymApp.service.UserService;

@Component
public class AppLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler{
	
	private Logger logger=Logger.getLogger(this.getClass().getName());

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserAnalyticsService userAnalyticsService;
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, 
			Authentication authentication) throws IOException, ServletException {
		
		String userEmail=authentication.getName();
		
		User user=userService.findByEmail(userEmail);
		
		ZoneId zoneId=ZoneId.systemDefault();
		TimeZone timeZone=TimeZone.getTimeZone(zoneId);
		
		logger.info(timeZone.toString());
				
		UserTimestamp userTimestamp=new UserTimestamp(UserAction.LogOut, LocalDateTime.now(zoneId), user.getId());
		  
		userAnalyticsService.save(userTimestamp);
	  
		logger.info(userTimestamp.toString());
		
		super.onLogoutSuccess(request, response, authentication);
	}
	
	
}
