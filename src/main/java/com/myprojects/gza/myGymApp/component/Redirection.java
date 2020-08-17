package com.myprojects.gza.myGymApp.component;

import java.util.Collection;
import java.util.logging.Logger;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class Redirection {
	
	private Logger logger=Logger.getLogger(this.getClass().getName());
	
	public String getHomePageByUserRole(Collection<? extends GrantedAuthority> authorities) {
		int priority=5;
		
		for(GrantedAuthority grantedAuthority: authorities) {
			logger.info(grantedAuthority.toString());
			
			if(grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				priority=Math.min(1, priority);
			}else if(grantedAuthority.getAuthority().equals("ROLE_MANAGER")) {
				priority=Math.min(2, priority);
			}else if(grantedAuthority.getAuthority().equals("ROLE_TRAINER")) {
				priority=Math.min(3, priority);
			}else if(grantedAuthority.getAuthority().equals("ROLE_EMPLOYEE")) {
				priority=Math.min(4, priority);
			}else if(grantedAuthority.getAuthority().equals("ROLE_CLIENT")) {
				priority=Math.min(5, priority);
			}
		}
		
		String redirectUrl=null;
		
		switch (priority) {
			case 1:
				redirectUrl="/user/admin/main";
				break;
			case 2:
				redirectUrl="/user/manager/main";
				break;
			case 3:
				redirectUrl="/user/trainer/main";
				break;
			case 4:
				redirectUrl="/user/employee/main";
				break;
			default:
				redirectUrl="/user/client/main";
				break;
		}
		return redirectUrl;
	}
}
