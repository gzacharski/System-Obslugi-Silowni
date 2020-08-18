package com.myprojects.gza.myGymApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.myprojects.gza.myGymApp.component.AppAuthenticationSuccessHandler;
import com.myprojects.gza.myGymApp.component.AppLogoutSuccessHandler;
import com.myprojects.gza.myGymApp.service.UserService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
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
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/trainers").permitAll()
				.antMatchers("/workouts").permitAll()
				.antMatchers("/fitnessEvents").permitAll()
				.antMatchers("/user/").hasAnyRole("ADMIN","CLIENT","EMPLOYEE","MANAGER","TRAINER")
				.antMatchers("/user/admin/**").hasRole("ADMIN")
				.antMatchers("/user/client/**").hasRole("CLIENT")
				.antMatchers("/user/employee/**").hasRole("EMPLOYEE")
				.antMatchers("/user/manager/**").hasRole("MANAGER")
				.antMatchers("/user/trainer/**").hasRole("TRAINER")
			.and()
				.formLogin()
				.loginPage("/logIn")
				.loginProcessingUrl("/authenticateUser")
				.successHandler(appAuthenticationSuccessHandler)
				.permitAll()
			.and()
				.logout()
				//.logoutUrl("/perform_logout")
				.logoutSuccessHandler(appLogoutSuccessHandler)
				//.logoutSuccessUrl("/logIn")
				.deleteCookies("JSESSIONID")
				.permitAll()
			.and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
		
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		
		return auth;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}



}
