package com.myprojects.gza.myGymApp.captcha;

import java.net.URI;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestOperations;

import com.myprojects.gza.myGymApp.errors.ReCaptchaInvalidException;
import com.myprojects.gza.myGymApp.errors.ReCaptchaUnavailableException;

@Service("captchaService")
public class CaptchaService implements ICaptchaService {
	
	private final static Logger LOGGER=Logger.getLogger(CaptchaService.class.getCanonicalName());
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private CaptchaSettings captchaSettings;
	
	@Autowired
	private RestOperations restTemplate;
	
	@Autowired
	private ReCaptchaAttemptService reCaptchaAttemptService;

	private static final Pattern RESPONSE_PATTERN=Pattern.compile("[A-Za-z0-9_-]+");
	private static final String RECAPTCHA_URL_TEMPLATE=
			"https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s";
	
	@Override
	public String getReCaptchaSite() {
		return captchaSettings.getSite();
	}

	@Override
	public String getReCaptchaSecret() {
		return captchaSettings.getSecret();
	}

	@Override
	public void processResponse(final String response) throws ReCaptchaInvalidException {

		securityCheck(response);
		
		LOGGER.info(response);
		
		final URI verifyURI=URI.create(String.format(RECAPTCHA_URL_TEMPLATE, getReCaptchaSecret(), response, getClientIP()));
		try {
			LOGGER.info(verifyURI);
			
			GoogleResponse googleResponse=restTemplate.getForObject(verifyURI, GoogleResponse.class);
			
			LOGGER.info("Google's response: {}");
			LOGGER.info(googleResponse.toString());
			
			if(!googleResponse.isSuccess()) {
				if(googleResponse.hasClientError()) {
					reCaptchaAttemptService.reCaptchaFailed(getClientIP());
				}
				throw new ReCaptchaInvalidException("ReCaptcha was not successfully validated");
			}
		}catch (Exception ex) {
			throw new ReCaptchaUnavailableException("Registration or logging is unavailable at this time.  "
					+ "Please try again later.", ex);
		}
		
		reCaptchaAttemptService.reCaptchaSucceeded(getClientIP());
	}
	
	private void securityCheck(final String response) {
		
		LOGGER.info("Attempting to validate response {}");
		LOGGER.info(response);
		
		if(reCaptchaAttemptService.isBlocked(getClientIP())) {
			throw new ReCaptchaInvalidException("Client exceeded maximum number of failed attempts");
		}
		
		if(!responseSanityCheck(response)) {
			throw new ReCaptchaInvalidException("Response contains invalid characters");
		}
	}
	
	private boolean responseSanityCheck(String response) {
		return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
	}
	
	private String getClientIP() {
		
		final String xfHeader=request.getHeader("X-Forwarded-For");
		if(xfHeader==null) {
			return request.getRemoteAddr();
		}
		
		return xfHeader.split(",")[0];
	}

}
