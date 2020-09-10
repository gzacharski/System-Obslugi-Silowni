package com.myprojects.gza.myGymApp.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.myprojects.gza.myGymApp.captcha.ICaptchaService;

public class CaptchaAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private static final String SPRING_SECURITY_FORM_RECAPTCHA_RESPONSE_KEY="g-recaptcha-response";
	
	@Autowired
	private ICaptchaService captchaService;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		UsernamePasswordAuthenticationToken authenticationRequest=getAuthenticationRequest(request);
		setDetails(request, authenticationRequest);
		
		System.out.println("authentication");
		
		return this.getAuthenticationManager().authenticate(authenticationRequest);
	}
	
	private UsernamePasswordAuthenticationToken getAuthenticationRequest(HttpServletRequest request) {
		
		String username=obtainUsername(request);
		String password=obtainPassword(request);
		
		getRecaptchaResponse(request);
		
		return new UsernamePasswordAuthenticationToken(username, password);
	}
	
	private void getRecaptchaResponse(HttpServletRequest request) {
		System.out.println("captcha loggin test");
		
		String responseCaptcha=request.getParameter(SPRING_SECURITY_FORM_RECAPTCHA_RESPONSE_KEY);
		
		captchaService.processResponse(responseCaptcha);
		
		System.out.println("captcha loggin test 2");
	}

}
