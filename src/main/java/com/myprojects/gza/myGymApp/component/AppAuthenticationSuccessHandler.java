package com.myprojects.gza.myGymApp.component;

import java.io.IOException;
import java.util.Collection;
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

import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.service.UserService;

@Component
public class AppAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Redirection redirection;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String userEmail=authentication.getName();
		
		User user=userService.findByEmail(userEmail);
		
		logger.info(user.toString());
		
		String redirectUrl=redirection.getHomePageByUserRole(authentication.getAuthorities());
		
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
		
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}

}
