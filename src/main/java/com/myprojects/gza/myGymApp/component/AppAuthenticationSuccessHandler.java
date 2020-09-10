package com.myprojects.gza.myGymApp.component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.TimeZone;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.myprojects.gza.myGymApp.captcha.ICaptchaService;
import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.entity.UserTimestamp;
import com.myprojects.gza.myGymApp.helperClasses.UserAction;
import com.myprojects.gza.myGymApp.service.UserAnalyticsService;
import com.myprojects.gza.myGymApp.service.UserService;

@Component
public class AppAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private ICaptchaService captchaService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserAnalyticsService userAnalyticsService;
	
	@Autowired
	private Redirection redirection;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		//String responseCaptcha=request.getParameter("g-recaptcha-response");
		//captchaService.processResponse(responseCaptcha);

		String userEmail=authentication.getName();
		
		User user=userService.findByEmail(userEmail);
		
		logger.info(user.toString());
		
		String redirectUrl=redirection.getHomePageByUserRole(authentication.getAuthorities());
		
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
		
		ZoneId zoneId=ZoneId.systemDefault();
		TimeZone timeZone=TimeZone.getTimeZone(zoneId);
		
		logger.info(timeZone.toString());
				
		UserTimestamp userTimestamp=new UserTimestamp(UserAction.LogIn,LocalDateTime.now(zoneId), user);
		  
		userAnalyticsService.save(userTimestamp);
	  
		logger.info(userTimestamp.toString());
		
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}

}
