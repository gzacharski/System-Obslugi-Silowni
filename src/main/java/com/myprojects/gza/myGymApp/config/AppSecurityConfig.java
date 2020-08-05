package com.myprojects.gza.myGymApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users=User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("gza").password("test123").roles("ADMIN"))
			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("test123").roles("CLIENT"));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/trainers").permitAll()
				.antMatchers("/workouts").permitAll()
				.antMatchers("/fitnessEvents").permitAll()
				.antMatchers("/client/**").hasRole("CLIENT")
				.antMatchers("/employee/**").hasRole("EMPLOYEE")
				.antMatchers("/admin/**").hasRole("ADMIN")
			.and()
				.formLogin()
				.loginPage("/logIn")
				.loginProcessingUrl("/authenticateUser")
				.permitAll()
			.and()
				.logout()
				.logoutSuccessUrl("/logIn")
				.permitAll();
	
	}

}
