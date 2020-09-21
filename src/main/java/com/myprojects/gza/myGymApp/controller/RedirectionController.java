package com.myprojects.gza.myGymApp.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myprojects.gza.myGymApp.component.Redirection;

@Controller
@RequestMapping("/user")
@PropertySource("classpath:aws-mysql.properties")
public class RedirectionController {
	
	@Autowired
	private Redirection redirection;
	
	private Logger logger=Logger.getLogger(this.getClass().getName());

	@GetMapping("/")
	public void redirectToProperHomePage(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		Cookie theCookie=returnIndicatedCookie(request.getCookies(),"leadingRole");

		String redirectUrl=null;
		
		if(theCookie!=null) {
			
			logger.info(theCookie.getName() + " " + theCookie.getValue());

			Collection<? extends GrantedAuthority> leadingRole=authentication.getAuthorities().stream()
														.filter(extracted(authentication, theCookie))
														.collect(Collectors.toList());
			
			logger.info(leadingRole.toString());
			redirectUrl = redirection.getHomePageByUserRole(leadingRole);
			
		}else {
			logger.info("There is any cookie");
			redirectUrl = redirection.getHomePageByUserRole(authentication.getAuthorities());
		}
	
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}
	
	@GetMapping("/setLeadingRole/{role}")
	public void setLeadingRole(@PathVariable String role, HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		logger.info(role.toString());
		
		Set<String> accessibleRoles=authentication.getAuthorities()
				.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
		
		logger.info(accessibleRoles.toString() +" "+  accessibleRoles.contains(role));
		
		if(accessibleRoles.contains(role)) {
			
		
			Cookie theCookie=returnIndicatedCookie(request.getCookies(),"leadingRole");
				
			if(theCookie==null) {
				logger.info("there is such a cookie");
				theCookie=new Cookie("leadingRole", role);
			}else {
				theCookie.setValue(role);
			}
			
			
			theCookie.setDomain("mygymapp-env.eba-jpprh8un.eu-central-1.elasticbeanstalk.com");
			theCookie.setMaxAge(3*60);
			theCookie.setPath("/");
			theCookie.setHttpOnly(true);
			response.addCookie(theCookie);
			
			logger.info(theCookie.getName() + " " + theCookie.getValue()+ " "+theCookie.getDomain());
		}
		
		redirectToProperHomePage(request, response, authentication);
	}
	
	private Predicate<GrantedAuthority> extracted(Authentication authentication, Cookie cookie) {
		return role -> role.getAuthority().equalsIgnoreCase(cookie.getValue());
	}
	
	private Cookie returnIndicatedCookie(Cookie[] arrayOfCookies, String cookieName) {
		
		Cookie tempCookie=null;
		
		if(arrayOfCookies!=null) {
			for(Cookie cookie: arrayOfCookies) {
				if(cookie.getName().equals(cookieName)) {
					tempCookie=cookie;
					break;
				}
			}
		}
		
		return tempCookie;
	}
	
	@GetMapping("/function")
	public String showErrorPage() {
		return "errors/error-404";
	}
	
}

