package com.myprojects.gza.myGymApp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myprojects.gza.myGymApp.component.Redirection;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private Redirection redirection;

	@GetMapping("/")
	public void redirectToProperHomePage(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String redirectUrl = redirection.getHomePageByUserRole(authentication.getAuthorities());
		
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}

	
}

