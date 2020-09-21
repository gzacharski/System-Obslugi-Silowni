package com.myprojects.gza.myGymApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.myprojects.gza.myGymApp.component.AppAuthenticationSuccessHandler;
import com.myprojects.gza.myGymApp.component.AppLogoutSuccessHandler;
import com.myprojects.gza.myGymApp.filter.CaptchaAuthenticationFilter;
import com.myprojects.gza.myGymApp.service.UserService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AppAuthenticationSuccessHandler appAuthenticationSuccessHandler;
	
	@Autowired
	private AppLogoutSuccessHandler appLogoutSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/user/admin/**").hasRole("ADMIN")
				.antMatchers("/user/client/**").hasRole("CLIENT")
				.antMatchers("/user/employee/**").hasRole("EMPLOYEE")
				.antMatchers("/user/manager/**").hasRole("MANAGER")
				.antMatchers("/user/trainer/**").hasRole("TRAINER")
				
				.antMatchers("/user/").hasAnyRole("ADMIN","CLIENT","EMPLOYEE","MANAGER","TRAINER")
				
				.antMatchers("/user/users/**").hasAnyRole("ADMIN","MANAGER","EMPLOYEE","TRAINER")
				
				.antMatchers("/user/events/**").hasAnyRole("ADMIN","MANAGER")
				.antMatchers("/user/equipments/**").hasAnyRole("ADMIN","MANAGER","EMPLOYEE")
				
				.antMatchers("/user/trainingRooms/**").hasAnyRole("ADMIN","MANAGER")
				.antMatchers("/user/trainers/**").hasAnyRole("ADMIN","MANAGER")
				.antMatchers("/user/workouts/**").hasAnyRole("ADMIN","MANAGER")
				
				.antMatchers("/").permitAll()
				.antMatchers("/trainers").permitAll()
				.antMatchers("/workouts").permitAll()
				.antMatchers("/fitnessEvents").permitAll()
			.and()
				.addFilterBefore(captchaAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
				.formLogin()
				.loginPage("/logIn")
				.loginProcessingUrl("/authenticateUser")
				.successHandler(appAuthenticationSuccessHandler)
				.permitAll()
			.and()
				.logout()
				.logoutSuccessHandler(appLogoutSuccessHandler)
				.deleteCookies("leadingRole", "JSESSIONID")
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/logIn?logout=true")
				.permitAll()
			.and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
		
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder);
		
		return auth;
	}
	
	
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}

	public CaptchaAuthenticationFilter captchaAuthenticationFilter() throws Exception{
		
		CaptchaAuthenticationFilter captchaFilter=new CaptchaAuthenticationFilter();		
		
		captchaFilter.setAuthenticationManager(authenticationManagerBean());
		captchaFilter.setAuthenticationFailureHandler(failureHandler());
		
		return captchaFilter;
	}
	

	private SimpleUrlAuthenticationFailureHandler failureHandler() {

		return new SimpleUrlAuthenticationFailureHandler("/logIn?captcha=true");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authenticationProvider());
	}
	
}
