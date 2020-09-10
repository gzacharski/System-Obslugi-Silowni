package com.myprojects.gza.myGymApp.captcha;

import com.myprojects.gza.myGymApp.errors.ReCaptchaInvalidException;

public interface ICaptchaService {
	
	void processResponse(final String response) throws ReCaptchaInvalidException;
	
	String getReCaptchaSite();
	
	String getReCaptchaSecret();
	
}
